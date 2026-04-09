# Mini Project - Quiz API

## What you'll build

A quiz application backend where you can add questions, take randomized quizzes, and get scored results. Think of it like building the backend for a Kahoot-style quiz app.

There are two parts:
1. **Admin side** - CRUD for managing questions (you've done this before!)
2. **Quiz side** - Start a quiz with random questions, submit answers, get your score

---

## New concepts

### Auto-generated IDs

In the banking lab, account numbers came from the client (`ACC001`, `ACC002`). In this project, the server generates IDs automatically using a counter:

```java
private int nextId = 1;

// When creating a question:
Question question = new Question(nextId++, ...);
// First question gets id=1, second gets id=2, etc.
```

The `nextId++` trick: it uses the current value of nextId, THEN increments it by 1. So it gives you 1, then becomes 2. Next time it gives you 2, then becomes 3.

### @RequestParam - Reading query parameters

You've used `@PathVariable` to read values from the URL path (`/api/questions/{id}`). `@RequestParam` reads values from the query string instead:

```
URL: /api/quiz/start?count=3
                     ^^^^^^^^^ this is a query parameter
```

```java
@GetMapping("/api/quiz/start")
public ResponseEntity<?> startQuiz(@RequestParam(defaultValue = "5") int count) {
    // count will be 3 if they send ?count=3
    // count will be 5 if they don't include it at all (default)
}
```

### Collections.shuffle() - Randomizing a list

Java has a built-in way to randomly reorder a list:

```java
List<String> names = new ArrayList<>(List.of("A", "B", "C", "D"));
Collections.shuffle(names);
// names might now be ["C", "A", "D", "B"] - random every time
```

Important: `shuffle()` modifies the list in place. If you don't want to mess up your original list, make a copy first:

```java
List<Question> shuffled = new ArrayList<>(questions); // copy
Collections.shuffle(shuffled);                        // shuffle the copy
```

### Hiding data - Question vs QuizQuestion

When someone takes a quiz, they should NOT see the correct answers. But your `Question` class has a `correctOption` field that would show up in the JSON.

Solution: use a different class (`QuizQuestion`) that has the same fields EXCEPT `correctOption`. Convert each `Question` to a `QuizQuestion` before sending it to the quiz taker.

```java
// Question has: id, questionText, optionA-D, correctOption, category
// QuizQuestion has: id, questionText, optionA-D, category  (no correctOption!)

QuizQuestion quizQ = new QuizQuestion(
    q.getId(), q.getQuestionText(),
    q.getOptionA(), q.getOptionB(),
    q.getOptionC(), q.getOptionD(),
    q.getCategory()
);
```

---

## Project structure

```
mini-project-01-quiz-api/
  pom.xml
  mini-project-01-quiz-api.rest              <-- test requests for all endpoints
  src/main/resources/
    application.properties                <-- server.port=8080
  src/main/java/com/training/quiz/
    QuizApplication.java                  <-- YOUR WORK GOES HERE (7 TODOs + 1 helper)
    Question.java                         <-- pre-built model (with answers)
    QuizQuestion.java                     <-- pre-built model (without answers)
    CreateQuestionRequest.java            <-- pre-built DTO for adding questions
    Answer.java                           <-- pre-built DTO for quiz submissions
    QuestionResult.java                   <-- pre-built DTO for graded result
    QuizResult.java                       <-- pre-built DTO for overall score
    ErrorResponse.java                    <-- pre-built error DTO
  solution/
    QuizApplication.java                  <-- complete working solution
```

---

## How to run

```bash
cd mini-project-01-quiz-api
mvn spring-boot:run
```

The server starts on **http://localhost:8080**

---

## Your tasks

Open `QuizApplication.java` and complete the 7 TODOs + 1 helper.

### Part 1: Question CRUD (you know this!)

These are the same patterns you used in the banking lab. The one difference: IDs are auto-generated using `nextId++` instead of coming from the client.

| TODO | Endpoint | What it does |
|------|----------|--------------|
| 1 | POST /api/questions | Add a question (auto-generate ID) |
| 2 | GET /api/questions | List all questions (includes answers) |
| 3 | GET /api/questions/{id} | Get one question, or 404 |
| 4 | PUT /api/questions/{id} | Update a question, or 404 |
| 5 | DELETE /api/questions/{id} | Delete a question, or 404 |

### Part 2: Quiz Flow (the fun part!)

| TODO | Endpoint | What it does |
|------|----------|--------------|
| 6 | GET /api/quiz/start?count=5 | Get random questions WITHOUT answers |
| 7 | POST /api/quiz/submit | Submit answers, get scored results |

### Helper method

| | Method | What it does |
|------|----------|--------------|
| Helper | findQuestion(int id) | Find question by ID, return null if not found |

---

## How to test

Use the `mini-project-01-quiz-api.rest` file. Follow this sequence:

### Setup (requests 1-6):
Add 6 questions across different categories.

### CRUD check (requests 7-10):
- List all questions (should see 6)
- Get one question (should see question 1 with answer)
- Update question 3 (should see updated text)
- Delete question 6 (should see confirmation)

### Take a quiz (requests 11-14):
- Start a quiz with 3 questions (should see 3 random questions WITHOUT correctOption)
- Start a quiz with default count (should see 5 questions)
- Submit perfect answers (should get score 5/5)
- Submit some wrong answers (should see which ones you got wrong)

### Error cases (requests 15-17):
- Get non-existent question (should get 404)
- Submit answer for non-existent question (should get 404)

---

## Done?

Check your work:

- [ ] POST creates a question with auto-generated ID and returns 201
- [ ] GET /api/questions returns all questions with correct answers visible
- [ ] GET /api/questions/{id} returns one question or 404
- [ ] PUT updates all question fields and returns 200 or 404
- [ ] DELETE removes a question and returns 200 or 404
- [ ] GET /api/quiz/start returns random questions WITHOUT the correctOption field
- [ ] GET /api/quiz/start?count=3 returns exactly 3 questions
- [ ] POST /api/quiz/submit scores answers and returns detailed results
- [ ] Submitting an answer for a non-existent question returns 404
- [ ] Starting a quiz with no questions returns 400

## Stretch goals (if you finish early)

Try these on your own - no solution provided:

1. **Filter by category**: Add `GET /api/questions/category/{category}` to list questions in a specific category
2. **Quiz by category**: Add an optional `category` query param to `/api/quiz/start?category=Science&count=3`
3. **High scores**: Track and return the top 5 quiz scores with `GET /api/quiz/leaderboard`

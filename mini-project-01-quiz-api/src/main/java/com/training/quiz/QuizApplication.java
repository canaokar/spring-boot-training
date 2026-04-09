package com.training.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
public class QuizApplication {

    // Storage for all questions
    private List<Question> questions = new ArrayList<>();

    // Auto-incrementing ID counter. Each new question gets the next number.
    // First question gets id=1, second gets id=2, etc.
    private int nextId = 1;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    // ================================================================
    //                     PART 1: QUESTION CRUD
    //   These are similar to what you did in the banking labs.
    //   The main difference: IDs are auto-generated, not provided
    //   by the client.
    // ================================================================

    // ================================================================
    // TODO 1: POST /api/questions - Add a new question
    // ================================================================
    // Annotation: @PostMapping("/api/questions")
    // Parameter: @RequestBody CreateQuestionRequest request
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Create a new Question using data from the request.
    //      For the id, use nextId++ (this gives the current value
    //      AND increments it for the next question)
    //   b) Add the question to the questions list
    //   c) Return the question with HTTP 201 (Created)
    // ================================================================


    // ================================================================
    // TODO 2: GET /api/questions - List all questions
    // ================================================================
    // Annotation: @GetMapping("/api/questions")
    // No parameters needed
    // Return type: ResponseEntity<List<Question>>
    //
    // Return the entire questions list with 200 OK.
    // Note: This is the "admin" view - it includes correct answers.
    // ================================================================


    // ================================================================
    // TODO 3: GET /api/questions/{id} - Get one question
    // ================================================================
    // Annotation: @GetMapping("/api/questions/{id}")
    // Parameter: @PathVariable int id
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Use findQuestion() to look up the question
    //   b) If null, return 404 with ErrorResponse
    //      - error: "NOT_FOUND"
    //      - message: "Question not found with id: " + id
    //   c) If found, return 200 OK with the question
    // ================================================================


    // ================================================================
    // TODO 4: PUT /api/questions/{id} - Update a question
    // ================================================================
    // Annotation: @PutMapping("/api/questions/{id}")
    // Parameters: @PathVariable int id,
    //             @RequestBody CreateQuestionRequest request
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Find the question by id
    //   b) If not found, return 404
    //   c) Update all fields: questionText, optionA, optionB,
    //      optionC, optionD, correctOption, category
    //   d) Return the updated question with 200 OK
    // ================================================================


    // ================================================================
    // TODO 5: DELETE /api/questions/{id} - Delete a question
    // ================================================================
    // Annotation: @DeleteMapping("/api/questions/{id}")
    // Parameter: @PathVariable int id
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Find the question by id
    //   b) If not found, return 404
    //   c) Remove it from the list
    //   d) Return 200 OK with: Map.of("message", "Question " + id + " deleted")
    //
    // Don't forget to import java.util.Map!
    // ================================================================


    // ================================================================
    //                     PART 2: QUIZ FLOW
    //   This is the fun part! These endpoints let someone actually
    //   TAKE a quiz and get their score.
    // ================================================================

    // ================================================================
    // TODO 6: GET /api/quiz/start?count=5 - Start a quiz
    // ================================================================
    // Annotation: @GetMapping("/api/quiz/start")
    // Parameter: @RequestParam(defaultValue = "5") int count
    // Return type: ResponseEntity<?>
    //
    // This endpoint returns random questions WITHOUT the correct
    // answer. You don't want quiz takers to see the answers!
    //
    // NEW CONCEPT - @RequestParam:
    //   Unlike @PathVariable (which is part of the URL path),
    //   @RequestParam reads from the query string: /api/quiz/start?count=5
    //   The defaultValue means if they don't provide count, it's 5.
    //
    // Steps:
    //   a) If the questions list is empty, return 400 Bad Request with
    //      ErrorResponse - error: "NO_QUESTIONS",
    //                      message: "No questions available. Add some questions first."
    //
    //   b) Create a copy of the questions list (don't shuffle the original!):
    //      List<Question> shuffled = new ArrayList<>(questions);
    //
    //   c) Shuffle the copy to randomize the order:
    //      Collections.shuffle(shuffled);
    //
    //   d) Figure out how many questions to return. If count is more
    //      than available questions, just use what we have:
    //      int quizSize = Math.min(count, shuffled.size());
    //
    //   e) Create a new list of QuizQuestion objects (NOT Question!).
    //      Loop from i=0 to quizSize, and for each Question in the
    //      shuffled list, create a new QuizQuestion with the same
    //      fields EXCEPT correctOption.
    //
    //   f) Return the QuizQuestion list with 200 OK
    // ================================================================


    // ================================================================
    // TODO 7: POST /api/quiz/submit - Submit answers and get score
    // ================================================================
    // Annotation: @PostMapping("/api/quiz/submit")
    // Parameter: @RequestBody List<Answer> answers
    // Return type: ResponseEntity<?>
    //
    // This is the most complex endpoint. You receive a list of answers,
    // grade each one, and return the results.
    //
    // Steps:
    //   a) Create an empty list to hold QuestionResult objects:
    //      List<QuestionResult> results = new ArrayList<>();
    //
    //   b) Create a score counter starting at 0
    //
    //   c) Loop through each Answer in the answers list:
    //      - Find the question using findQuestion(answer.getQuestionId())
    //      - If the question is null, return 404 with ErrorResponse:
    //        error: "NOT_FOUND"
    //        message: "Question not found: " + answer.getQuestionId()
    //
    //      - Check if the answer is correct:
    //        question.getCorrectOption().equalsIgnoreCase(answer.getSelectedOption())
    //
    //      - If correct, increment the score
    //
    //      - Create a new QuestionResult with:
    //        questionId, questionText, selectedOption, correctOption,
    //        and whether it was correct (true/false)
    //
    //      - Add the QuestionResult to the results list
    //
    //   d) Create a new QuizResult with the score, total questions
    //      (results.size()), and the results list
    //
    //   e) Return the QuizResult with 200 OK
    // ================================================================


    // ================================================================
    // HELPER: Find a question by ID
    // ================================================================
    // Same pattern as findAccount() from the banking lab.
    // Loop through questions, find the one with matching id.
    // Return the Question if found, null if not.
    //
    // Note: Use == for int comparison, not .equals()
    //       (question.getId() == id)
    // ================================================================
    private Question findQuestion(int id) {
        return null; // Replace this with your loop logic
    }
}

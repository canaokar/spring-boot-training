package com.training.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class QuizApplication {

    private List<Question> questions = new ArrayList<>();
    private int nextId = 1;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    // ==================== PART 1: QUESTION CRUD ====================

    // POST /api/questions - Add a new question
    @PostMapping("/api/questions")
    public ResponseEntity<?> addQuestion(@RequestBody CreateQuestionRequest request) {
        Question question = new Question(
                nextId++,
                request.getQuestionText(),
                request.getOptionA(),
                request.getOptionB(),
                request.getOptionC(),
                request.getOptionD(),
                request.getCorrectOption(),
                request.getCategory()
        );
        questions.add(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }

    // GET /api/questions - List all questions
    @GetMapping("/api/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questions);
    }

    // GET /api/questions/{id} - Get one question
    @GetMapping("/api/questions/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable int id) {
        Question question = findQuestion(id);
        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT_FOUND", "Question not found with id: " + id));
        }
        return ResponseEntity.ok(question);
    }

    // PUT /api/questions/{id} - Update a question
    @PutMapping("/api/questions/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable int id,
                                            @RequestBody CreateQuestionRequest request) {
        Question question = findQuestion(id);
        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT_FOUND", "Question not found with id: " + id));
        }
        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectOption(request.getCorrectOption());
        question.setCategory(request.getCategory());
        return ResponseEntity.ok(question);
    }

    // DELETE /api/questions/{id} - Delete a question
    @DeleteMapping("/api/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable int id) {
        Question question = findQuestion(id);
        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT_FOUND", "Question not found with id: " + id));
        }
        questions.remove(question);
        return ResponseEntity.ok(Map.of("message", "Question " + id + " deleted"));
    }

    // ==================== PART 2: QUIZ FLOW ====================

    // GET /api/quiz/start?count=5 - Start a quiz
    @GetMapping("/api/quiz/start")
    public ResponseEntity<?> startQuiz(@RequestParam(defaultValue = "5") int count) {
        if (questions.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("NO_QUESTIONS", "No questions available. Add some questions first."));
        }

        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);

        int quizSize = Math.min(count, shuffled.size());
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        for (int i = 0; i < quizSize; i++) {
            Question q = shuffled.get(i);
            quizQuestions.add(new QuizQuestion(
                    q.getId(),
                    q.getQuestionText(),
                    q.getOptionA(),
                    q.getOptionB(),
                    q.getOptionC(),
                    q.getOptionD(),
                    q.getCategory()
            ));
        }

        return ResponseEntity.ok(quizQuestions);
    }

    // POST /api/quiz/submit - Submit answers and get score
    @PostMapping("/api/quiz/submit")
    public ResponseEntity<?> submitAnswers(@RequestBody List<Answer> answers) {
        List<QuestionResult> results = new ArrayList<>();
        int score = 0;

        for (Answer answer : answers) {
            Question question = findQuestion(answer.getQuestionId());
            if (question == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("NOT_FOUND",
                                "Question not found: " + answer.getQuestionId()));
            }

            boolean correct = question.getCorrectOption()
                    .equalsIgnoreCase(answer.getSelectedOption());
            if (correct) {
                score++;
            }

            results.add(new QuestionResult(
                    question.getId(),
                    question.getQuestionText(),
                    answer.getSelectedOption(),
                    question.getCorrectOption(),
                    correct
            ));
        }

        return ResponseEntity.ok(new QuizResult(score, results.size(), results));
    }

    // Helper - find a question by ID
    private Question findQuestion(int id) {
        for (Question question : questions) {
            if (question.getId() == id) {
                return question;
            }
        }
        return null;
    }
}

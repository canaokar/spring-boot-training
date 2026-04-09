package com.training.quiz;

/**
 * Result for a single question after grading.
 *
 * After a quiz is submitted, each question gets one of these showing:
 * - What the student picked
 * - What the correct answer was
 * - Whether they got it right
 *
 * Example JSON:
 * {
 *   "questionId": 1,
 *   "questionText": "What is the capital of France?",
 *   "selectedOption": "C",
 *   "correctOption": "C",
 *   "correct": true
 * }
 */
public class QuestionResult {

    private int questionId;
    private String questionText;
    private String selectedOption;
    private String correctOption;
    private boolean correct;

    public QuestionResult(int questionId, String questionText, String selectedOption,
                          String correctOption, boolean correct) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.selectedOption = selectedOption;
        this.correctOption = correctOption;
        this.correct = correct;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public boolean isCorrect() {
        return correct;
    }
}

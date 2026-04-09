package com.training.quiz;

/**
 * Represents one answer submitted by a quiz taker.
 *
 * When someone finishes a quiz, they submit a list of these.
 * Each Answer says "for question X, I chose option Y".
 *
 * Example JSON (one answer):
 * {
 *   "questionId": 1,
 *   "selectedOption": "C"
 * }
 */
public class Answer {

    private int questionId;
    private String selectedOption; // "A", "B", "C", or "D"

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
}

package com.training.quiz;

/**
 * DTO for adding a new question (POST request body).
 *
 * Notice there's no "id" field here - the server generates the ID
 * automatically using a counter. The client only provides the
 * question content.
 *
 * Example JSON:
 * {
 *   "questionText": "What is the capital of France?",
 *   "optionA": "London",
 *   "optionB": "Berlin",
 *   "optionC": "Paris",
 *   "optionD": "Madrid",
 *   "correctOption": "C",
 *   "category": "Geography"
 * }
 */
public class CreateQuestionRequest {

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
    private String category;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

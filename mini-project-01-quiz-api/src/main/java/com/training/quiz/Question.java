package com.training.quiz;

/**
 * Represents a quiz question with four options and a correct answer.
 *
 * This is the main model - it stores everything about a question,
 * including the correct answer. Think of this as the "answer key" version
 * that only the quiz creator should see.
 *
 * When a student takes a quiz, they should NOT see the correctOption field.
 * That's what QuizQuestion is for - a version without the answer.
 */
public class Question {

    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption; // "A", "B", "C", or "D"
    private String category;

    public Question(int id, String questionText, String optionA, String optionB,
                    String optionC, String optionD, String correctOption, String category) {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.category = category;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public String getCategory() {
        return category;
    }

    // Setters - needed for PUT updates

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

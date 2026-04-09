package com.training.quiz;

/**
 * A quiz question WITHOUT the correct answer.
 *
 * When someone takes a quiz, they should see the question and options
 * but NOT the correct answer. This class is like Question but with
 * the correctOption field removed.
 *
 * Your job in TODO 6 is to convert Question objects into QuizQuestion
 * objects before sending them to the quiz taker.
 */
public class QuizQuestion {

    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String category;

    public QuizQuestion(int id, String questionText, String optionA, String optionB,
                        String optionC, String optionD, String category) {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.category = category;
    }

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

    public String getCategory() {
        return category;
    }
}

package com.training.quiz;

import java.util.List;

/**
 * The overall result of a quiz submission.
 *
 * Contains the score, total questions, and a breakdown of each question.
 *
 * Example JSON:
 * {
 *   "score": 3,
 *   "totalQuestions": 5,
 *   "results": [ ... QuestionResult objects ... ]
 * }
 */
public class QuizResult {

    private int score;
    private int totalQuestions;
    private List<QuestionResult> results;

    public QuizResult(int score, int totalQuestions, List<QuestionResult> results) {
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.results = results;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public List<QuestionResult> getResults() {
        return results;
    }
}

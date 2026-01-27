package com.chinmay.postvalidation;

public class SuccessResponse {

    private String message;
    private Student student;

    public SuccessResponse(String message, Student student) {
        this.message = message;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public Student getStudent() {
        return student;
    }
}

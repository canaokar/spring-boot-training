package com.training.quiz;

/**
 * DTO for error responses.
 *
 * Same pattern as the banking labs - when something goes wrong,
 * return this instead of the normal response.
 */
public class ErrorResponse {

    private String error;
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}

package com.training.banking.exception;

// ============================================================
// TODO: Add the necessary import statements.
//
// You will need:
//   import org.springframework.http.HttpStatus;
//   import org.springframework.http.ResponseEntity;
//   import org.springframework.web.bind.MethodArgumentNotValidException;
//   import org.springframework.web.bind.annotation.ExceptionHandler;
//   import org.springframework.web.bind.annotation.RestControllerAdvice;
//   import java.util.HashMap;
//   import java.util.Map;
// ============================================================

/**
 * Global exception handler for validation errors.
 *
 * When Spring validates a request body (because of @Valid) and finds
 * problems, it throws a MethodArgumentNotValidException. Without this
 * handler, the client would see an ugly 403 error with a huge stack trace.
 *
 * This class catches that exception and returns a clean JSON response
 * like this:
 *
 *   {
 *     "accountNumber": "Account number must be 8 digits",
 *     "holderName": "must not be blank"
 *   }
 *
 * Think of it like a receptionist at a bank. When the form checker
 * (validation) finds problems, the receptionist doesn't dump a pile
 * of internal paperwork on the customer. Instead, they hand back the
 * form with neat notes: "This field is missing" and "This format is wrong."
 *
 * YOUR WORK: Complete the three TODOs below.
 */
// ============================================================
// TODO 5: Add @RestControllerAdvice annotation to this class
// ============================================================
// @RestControllerAdvice tells Spring: "This class handles exceptions
// for ALL controllers in the application."
//
// It's like appointing a head receptionist who handles complaints
// from every department, not just one.
//
// Just add the annotation above the class declaration.
// ============================================================
public class ValidationExceptionHandler {

    // ============================================================
    // TODO 6: Add a method to handle MethodArgumentNotValidException
    // ============================================================
    // Create a method with this signature:
    //
    //   @ExceptionHandler(MethodArgumentNotValidException.class)
    //   public ResponseEntity<Map<String, String>> handleValidationErrors(
    //       MethodArgumentNotValidException ex) {
    //       // ... your code here
    //   }
    //
    // The @ExceptionHandler annotation tells Spring: "When this
    // specific exception is thrown, call this method to handle it."
    //
    // ============================================================

    // ============================================================
    // TODO 7: Inside the method, extract field errors and return them
    // ============================================================
    // Steps:
    //   1. Create a new HashMap<String, String> called "errors"
    //   2. Loop through the field errors from the exception:
    //
    //      ex.getBindingResult().getFieldErrors().forEach(error ->
    //          errors.put(error.getField(), error.getDefaultMessage())
    //      );
    //
    //   3. Return the map with a 400 (Bad Request) status:
    //
    //      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //
    // This turns a messy exception into a clean JSON response where
    // each key is the field name and each value is the error message.
    // ============================================================
}

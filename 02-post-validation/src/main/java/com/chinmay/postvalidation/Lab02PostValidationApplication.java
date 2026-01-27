package com.chinmay.postvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Lab02PostValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab02PostValidationApplication.class, args);
    }

    // Fixed-size in-memory store (no Map)
    private final Student[] students = new Student[20];
    private int count = 0;

    // TODO: POST /api/students
    // Body: { "id":"S1", "name":"Asha", "email":"asha@x.com" }
    //
    // Rules:
    // - id, name, email are required (not null, not blank)
    // - id must start with "S" and length >= 2 (examples: S1, S10, S123)
    // - email must contain '@' and '.'
    // - if id already exists -> 409 with JSON error
    // - if array is full -> 409 with JSON error "STORE_FULL"
    // - on success -> 201 with JSON success { message, student }
    //
    // Constraints:
    // - NO Map usage
    // - DO NOT use validation annotations
    // - Use ErrorResponse and SuccessResponse classes
    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequest req) {
        // TODO 1: Validate required fields (id/name/email)

        // TODO 2: Validate id format

        // TODO 3: Validate email format

        // TODO 4: Check store full

        // TODO 5: Check duplicate ID using findIndexById

        // TODO 6: Create Student and store it

        // TODO 7: Return 201 with SuccessResponse

        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(new ErrorResponse("NOT_IMPLEMENTED", "Complete TODOs in POST /api/students"));
    }

    // TODO: GET /api/students/{id}
    // - if found -> 200 with Student JSON
    // - if not found -> 404 with ErrorResponse JSON
    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(new ErrorResponse("NOT_IMPLEMENTED", "Complete TODOs in GET /api/students/{id}"));
    }

    // Helper: find index by id, return -1 if not found
    // TODO: implement without Map
    private int findIndexById(String id) {
        return -1;
    }

    // Helper: true if null or blank
    // TODO: implement
    private boolean isBlank(String s) {
        return true;
    }

    // Helper: validate id format
    // TODO: implement
    private boolean isValidStudentId(String id) {
        return false;
    }

    // Helper: validate email format (simple)
    // TODO: implement
    private boolean isValidEmail(String email) {
        return false;
    }
}

package com.training.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Lab 02 - POST with Manual Validation
 *
 * In this lab you will build two endpoints for a simple banking API:
 *   1. POST /api/accounts   - create a new bank account
 *   2. GET  /api/accounts/{accountNumber} - retrieve an account by its number
 *
 * The account data is stored in a plain array (no databases yet).
 * You will write manual validation - checking each field yourself
 * with if/else, just like a bank clerk checking a paper form.
 *
 * Follow the numbered TODOs below.
 */
@SpringBootApplication
@RestController
@RequestMapping("/api/accounts")
public class Lab02PostValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab02PostValidationApplication.class, args);
    }

    // Storage - a fixed-size array, like a filing cabinet with 20 slots
    private Account[] accounts = new Account[20];
    private int count = 0;

    // ========================================================================
    // POST /api/accounts - Create a new bank account
    // ========================================================================

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request) {

        // ----------------------------------------------------------------
        // TODO 1: Validate all fields
        //
        // Check each field and return 400 (Bad Request) if invalid.
        // Use the helper methods at the bottom of this file.
        //
        // Rules:
        //   - holderName: must not be blank
        //       Error message: "Holder name is required"
        //   - accountNumber: must not be blank AND must be exactly 8 digits
        //       Error messages: "Account number is required"
        //                       "Account number must be exactly 8 digits"
        //   - sortCode: must not be blank AND must match format XX-XX-XX
        //       Error messages: "Sort code is required"
        //                       "Sort code must be in format XX-XX-XX (e.g. 12-34-56)"
        //   - openingBalance: must be >= 0
        //       Error message: "Opening balance must not be negative"
        //
        // For each failed check, return:
        //   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        //       .body(new ErrorResponse("BAD_REQUEST", "the error message"));
        //
        // Write your validation code here:
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
        // TODO 2: Check for duplicate account number
        //
        // Loop through the accounts array (from 0 to count - 1).
        // If any existing account has the same accountNumber, return 409:
        //
        //   return ResponseEntity.status(HttpStatus.CONFLICT)
        //       .body(new ErrorResponse("DUPLICATE_ACCOUNT",
        //           "Account " + request.getAccountNumber() + " already exists"));
        //
        // Write your duplicate check here:
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
        // TODO 3: Check if the store is full
        //
        // If count >= accounts.length, the filing cabinet is full.
        // Return 409:
        //
        //   return ResponseEntity.status(HttpStatus.CONFLICT)
        //       .body(new ErrorResponse("STORE_FULL",
        //           "Maximum account limit reached"));
        //
        // Write your capacity check here:
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
        // TODO 4: Create the Account and store it
        //
        // Create a new Account object using the request data:
        //   Account account = new Account(
        //       request.getAccountNumber(),
        //       request.getSortCode(),
        //       request.getHolderName(),
        //       request.getOpeningBalance()
        //   );
        //
        // Store it in the array at position "count", then increment count.
        //
        // Write your code here:
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
        // TODO 5: Return 201 Created with a SuccessResponse
        //
        // Return:
        //   return ResponseEntity.status(HttpStatus.CREATED)
        //       .body(new SuccessResponse("Account created successfully", account));
        //
        // Write your return statement here:
        // ----------------------------------------------------------------


        // Remove this line once you complete TODOs 4 and 5 above
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("NOT_IMPLEMENTED", "Complete the TODOs to implement this endpoint"));
    }

    // ========================================================================
    // GET /api/accounts/{accountNumber} - Retrieve an account
    // ========================================================================

    // ----------------------------------------------------------------
    // TODO 6: Implement the GET endpoint
    //
    // Add the method annotation: @GetMapping("/{accountNumber}")
    //
    // Method signature:
    //   public ResponseEntity<?> getAccount(@PathVariable String accountNumber)
    //
    // Logic:
    //   1. Loop through accounts array (from 0 to count - 1)
    //   2. If you find a matching accountNumber, return 200 with the Account
    //      return ResponseEntity.ok(account);
    //   3. If no match found, return 404:
    //      return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //          .body(new ErrorResponse("NOT_FOUND",
    //              "Account " + accountNumber + " not found"));
    //
    // Write your GET endpoint here:
    // ----------------------------------------------------------------



    // ========================================================================
    // Helper methods - implement these first, the validation above uses them
    // ========================================================================

    // ----------------------------------------------------------------
    // TODO 7: Implement isBlank(String value)
    //
    // Returns true if the value is null OR empty after trimming whitespace.
    // Example:
    //   isBlank(null)   -> true
    //   isBlank("")     -> true
    //   isBlank("  ")   -> true
    //   isBlank("Asha") -> false
    //
    // Hint: value == null || value.trim().isEmpty()
    // ----------------------------------------------------------------
    private boolean isBlank(String value) {
        // Replace "false" with your implementation
        return false;
    }

    // ----------------------------------------------------------------
    // TODO 8: Implement isValidAccountNumber(String accountNumber)
    //
    // Returns true if the account number is exactly 8 characters long
    // and every character is a digit (0-9).
    //
    // Hint: Check length first, then use accountNumber.matches("\\d{8}")
    //       The regex \\d means "any digit" and {8} means "exactly 8 times"
    // ----------------------------------------------------------------
    private boolean isValidAccountNumber(String accountNumber) {
        // Replace "true" with your implementation
        return true;
    }

    // ----------------------------------------------------------------
    // TODO 9: Implement isValidSortCode(String sortCode)
    //
    // Returns true if the sort code matches the format XX-XX-XX
    // where X is a digit. Examples: "12-34-56" is valid, "1234-56" is not.
    //
    // Hint: use sortCode.matches("\\d{2}-\\d{2}-\\d{2}")
    // ----------------------------------------------------------------
    private boolean isValidSortCode(String sortCode) {
        // Replace "true" with your implementation
        return true;
    }
}

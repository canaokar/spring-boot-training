package com.training.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Lab03FullCrudApplication {

    // Storage for all accounts - an ArrayList that grows as accounts are added.
    // Unlike a fixed-size array, this list expands automatically.
    private List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Lab03FullCrudApplication.class, args);
    }

    // ================================================================
    // TODO 1: POST /api/accounts - Create a new account
    // ================================================================
    // Annotation: @PostMapping("/api/accounts")
    // Parameter: @RequestBody CreateAccountRequest request
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Create a new Account object using the data from the request:
    //      - accountNumber comes from request.getAccountNumber()
    //      - holderName comes from request.getHolderName()
    //      - balance comes from request.getOpeningBalance()
    //      - accountType comes from request.getAccountType()
    //   b) Add the new account to the accounts list
    //   c) Return the account with HTTP 201 (Created)
    //
    // Hint: ResponseEntity.status(HttpStatus.CREATED).body(account)
    // ================================================================


    // ================================================================
    // TODO 2: GET /api/accounts - List all accounts
    // ================================================================
    // Annotation: @GetMapping("/api/accounts")
    // No parameters needed
    // Return type: ResponseEntity<List<Account>>
    //
    // This is the simplest endpoint - just return the whole list.
    //
    // Hint: ResponseEntity.ok(accounts)
    // ================================================================


    // ================================================================
    // TODO 3: GET /api/accounts/{accountNumber} - Get one account
    // ================================================================
    // Annotation: @GetMapping("/api/accounts/{accountNumber}")
    // Parameter: @PathVariable String accountNumber
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Use the findAccount() helper method to look up the account
    //   b) If the account is null (not found), return 404 with an
    //      ErrorResponse - error: "NOT_FOUND",
    //                       message: "Account not found: " + accountNumber
    //   c) If found, return 200 OK with the account
    //
    // Hint for 404: ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse)
    // ================================================================


    // ================================================================
    // TODO 4: PUT /api/accounts/{accountNumber} - Full update
    // ================================================================
    // Annotation: @PutMapping("/api/accounts/{accountNumber}")
    // Parameters: @PathVariable String accountNumber,
    //             @RequestBody UpdateAccountRequest request
    // Return type: ResponseEntity<?>
    //
    // PUT replaces the updatable fields entirely - like rewriting a form.
    // We update holderName and accountType, but NOT balance or accountNumber.
    //
    // Steps:
    //   a) Use findAccount() to look up the account
    //   b) If not found, return 404 with ErrorResponse
    //   c) Update the account's holderName using account.setHolderName(...)
    //   d) Update the account's accountType using account.setAccountType(...)
    //   e) Return the updated account with 200 OK
    // ================================================================


    // ================================================================
    // TODO 5: PATCH /api/accounts/{accountNumber}/deposit - Deposit money
    // ================================================================
    // Annotation: @PatchMapping("/api/accounts/{accountNumber}/deposit")
    // Parameters: @PathVariable String accountNumber,
    //             @RequestBody AmountRequest request
    // Return type: ResponseEntity<?>
    //
    // PATCH modifies just one part - the balance. Everything else stays the same.
    //
    // Steps:
    //   a) Use findAccount() to look up the account
    //   b) If not found, return 404 with ErrorResponse
    //   c) Add the deposit amount to the current balance:
    //      account.setBalance(account.getBalance() + request.getAmount())
    //   d) Return the updated account with 200 OK
    // ================================================================


    // ================================================================
    // TODO 6: PATCH /api/accounts/{accountNumber}/withdraw - Withdraw money
    // ================================================================
    // Annotation: @PatchMapping("/api/accounts/{accountNumber}/withdraw")
    // Parameters: @PathVariable String accountNumber,
    //             @RequestBody AmountRequest request
    // Return type: ResponseEntity<?>
    //
    // Similar to deposit, but we need to check if there's enough money first.
    // You can't withdraw more than what's in the account.
    //
    // Steps:
    //   a) Use findAccount() to look up the account
    //   b) If not found, return 404 with ErrorResponse
    //   c) Check if balance >= amount requested
    //   d) If not enough funds, return 400 Bad Request with ErrorResponse:
    //      - error: "INSUFFICIENT_FUNDS"
    //      - message: "Cannot withdraw " + request.getAmount()
    //               + " from account with balance " + account.getBalance()
    //   e) If enough, subtract the amount from the balance
    //   f) Return the updated account with 200 OK
    //
    // Hint for 400: ResponseEntity.badRequest().body(errorResponse)
    // ================================================================


    // ================================================================
    // TODO 7: DELETE /api/accounts/{accountNumber} - Close/remove account
    // ================================================================
    // Annotation: @DeleteMapping("/api/accounts/{accountNumber}")
    // Parameter: @PathVariable String accountNumber
    // Return type: ResponseEntity<?>
    //
    // Steps:
    //   a) Use findAccount() to look up the account
    //   b) If not found, return 404 with ErrorResponse
    //   c) Remove the account from the list: accounts.remove(account)
    //   d) Return 200 OK with a confirmation message. Use a Map:
    //      Map.of("message", "Account " + accountNumber + " has been closed")
    //
    // Hint: ResponseEntity.ok(Map.of("message", "Account ... has been closed"))
    // ================================================================


    // ================================================================
    // HELPER: Find an account by account number
    // ================================================================
    // This method is used by almost every endpoint above.
    // It loops through the accounts list and returns the matching account,
    // or null if no account has that number.
    //
    // Steps:
    //   a) Loop through the accounts list (for-each loop)
    //   b) Check if account.getAccountNumber().equals(accountNumber)
    //   c) If it matches, return that account
    //   d) If the loop finishes without finding one, return null
    // ================================================================
    private Account findAccount(String accountNumber) {
        return null; // Replace this with your loop logic
    }
}

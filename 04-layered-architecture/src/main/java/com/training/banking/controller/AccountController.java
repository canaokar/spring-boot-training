package com.training.banking.controller;

import com.training.banking.dto.CreateAccountRequest;
import com.training.banking.dto.ErrorResponse;
import com.training.banking.model.Account;
import com.training.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller layer for account endpoints.
 *
 * This class is the "teller" of the bank. It handles HTTP requests,
 * calls the service to do the actual work, and sends back HTTP responses.
 *
 * Notice: this class has NO ArrayList, NO validation logic, NO account
 * number generation. All of that lives in the service layer.
 *
 * Complete the TODOs below to wire everything up.
 */
// ============================================================
// TODO 1: Add class-level annotations
// ============================================================
// Add TWO annotations to this class:
//
//   @RestController - tells Spring this class handles HTTP requests
//   @RequestMapping("/api/accounts") - sets the base URL path
//
// With @RequestMapping on the class, all methods inside share that
// base path. So a @GetMapping here maps to GET /api/accounts.
// ============================================================
public class AccountController {

    // ============================================================
    // TODO 2: Add AccountService field and constructor
    // ============================================================
    // Declare a field:
    //   private final AccountService accountService;
    //
    // Create a constructor that takes AccountService as a parameter
    // and assigns it to the field. Add @Autowired on the constructor.
    //
    //   @Autowired
    //   public AccountController(AccountService accountService) {
    //       this.accountService = accountService;
    //   }
    //
    // This is constructor injection. When Spring creates the controller,
    // it sees the constructor needs an AccountService, finds the one it
    // already created (because of @Service), and passes it in.
    //
    // Hint: you need to import org.springframework.beans.factory.annotation.Autowired
    // ============================================================


    // ============================================================
    // TODO 3: Implement POST / (create account)
    // ============================================================
    // Add a method with @PostMapping that:
    //   a) Takes a @RequestBody CreateAccountRequest parameter
    //   b) Calls accountService.createAccount(request) inside a try block
    //   c) If successful, returns ResponseEntity with status 201 (Created)
    //      and the Account in the body
    //   d) If the service throws IllegalArgumentException, catches it
    //      and returns 400 (Bad Request) with an ErrorResponse containing
    //      error="BAD_REQUEST" and the exception message
    //
    // Hint for 201 status:
    //   return ResponseEntity.status(201).body(account);
    //
    // Hint for 400 status:
    //   return ResponseEntity.badRequest().body(new ErrorResponse(...));
    // ============================================================


    // ============================================================
    // TODO 4: Implement GET / (list all accounts)
    // ============================================================
    // Add a method with @GetMapping that:
    //   a) Calls accountService.getAllAccounts()
    //   b) Returns the list with 200 OK
    //
    // This is the simplest endpoint. One line of real logic.
    //
    // Hint: return ResponseEntity.ok(accountService.getAllAccounts());
    // ============================================================


    // ============================================================
    // TODO 5: Implement GET /{accountNumber} (get one account)
    // ============================================================
    // Add a method with @GetMapping("/{accountNumber}") that:
    //   a) Takes a @PathVariable String accountNumber parameter
    //   b) Calls accountService.getAccount(accountNumber)
    //   c) If the result is null, returns 404 with an ErrorResponse
    //      containing error="NOT_FOUND" and
    //      message="Account not found: " + accountNumber
    //   d) If found, returns 200 with the Account
    //
    // Hint: use a simple if/else
    // ============================================================


    // ============================================================
    // TODO 6: Implement DELETE /{accountNumber} (delete account)
    // ============================================================
    // Add a method with @DeleteMapping("/{accountNumber}") that:
    //   a) Takes a @PathVariable String accountNumber parameter
    //   b) Calls accountService.deleteAccount(accountNumber)
    //   c) If the result is false (account not found), returns 404
    //      with an ErrorResponse containing error="NOT_FOUND" and
    //      message="Account not found: " + accountNumber
    //   d) If the result is true, returns 200 with a simple message.
    //      You can return a Map or just a string.
    //
    // Hint for the success response, you can use:
    //   return ResponseEntity.ok(Map.of("message", "Account deleted: " + accountNumber));
    //   (import java.util.Map)
    // ============================================================

}

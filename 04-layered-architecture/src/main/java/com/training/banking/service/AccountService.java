package com.training.banking.service;

import com.training.banking.dto.CreateAccountRequest;
import com.training.banking.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for account operations.
 *
 * This class is the "manager" of the bank. It contains all the business
 * logic - validation, account creation, data storage, lookups, and deletion.
 *
 * Notice: this class knows NOTHING about HTTP. No ResponseEntity, no status
 * codes, no @GetMapping. It just works with plain Java objects.
 *
 * Complete the TODOs below to implement the service.
 */
// ============================================================
// TODO 1: Add the @Service annotation
// ============================================================
// This tells Spring: "Create one instance of this class and manage it."
// Without this, Spring will not know this class exists, and the
// controller will fail to start because it cannot find an AccountService.
//
// Hint: You need to import org.springframework.stereotype.Service
// ============================================================
public class AccountService {

    // ============================================================
    // TODO 2: Add a private field to store accounts
    // ============================================================
    // Declare: private List<Account> accounts = new ArrayList<>();
    //
    // Also add a counter for generating account numbers:
    // private int nextId = 1;
    //
    // This ArrayList acts as our "database" for now. Every account
    // we create gets added here. Because Spring creates only ONE
    // AccountService instance, all controllers share this same list.
    // ============================================================


    // ============================================================
    // TODO 3: Implement createAccount
    // ============================================================
    // Method signature: public Account createAccount(CreateAccountRequest request)
    //
    // Steps:
    //   a) Validate that holderName is not null or blank.
    //      If invalid, throw new IllegalArgumentException("holderName is required")
    //
    //   b) Validate that sortCode is not null or blank.
    //      If invalid, throw new IllegalArgumentException("sortCode is required")
    //
    //   c) Validate that openingBalance is not negative.
    //      If invalid, throw new IllegalArgumentException("openingBalance cannot be negative")
    //
    //   d) Generate an account number: "ACC-" + nextId, then increment nextId
    //
    //   e) Create a new Account object with the generated number,
    //      sortCode, holderName, and openingBalance from the request
    //
    //   f) Add it to the accounts list
    //
    //   g) Return the new Account
    //
    // Notice: we throw exceptions here, NOT return ResponseEntity.
    // The controller will catch these and decide what HTTP status to use.
    // ============================================================


    // ============================================================
    // TODO 4: Implement getAllAccounts
    // ============================================================
    // Method signature: public List<Account> getAllAccounts()
    //
    // Just return the accounts list. That is it.
    // ============================================================


    // ============================================================
    // TODO 5: Implement getAccount
    // ============================================================
    // Method signature: public Account getAccount(String accountNumber)
    //
    // Loop through the accounts list. If you find one where
    // account.getAccountNumber().equals(accountNumber), return it.
    //
    // If no match is found, return null.
    //
    // Hint: a simple for loop works fine here.
    // ============================================================


    // ============================================================
    // TODO 6: Implement deleteAccount
    // ============================================================
    // Method signature: public boolean deleteAccount(String accountNumber)
    //
    // Loop through the accounts list. If you find a matching account,
    // remove it from the list and return true.
    //
    // If no match is found, return false.
    //
    // Hint: use accounts.remove(account) inside the loop, but be
    // careful - you cannot remove from a list while iterating with
    // a for-each loop. Use an Iterator or find the account first,
    // then remove it after the loop.
    // ============================================================

}

package com.training.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@SpringBootApplication
@RestController
public class Lab01GetLogicApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab01GetLogicApplication.class, args);
    }

    /**
     * GET /api/rates?accountType=savings&currency=GBP
     *
     * Returns interest rate information for the given account type and currency.
     *
     * @param accountType - optional, defaults to CURRENT. Allowed: SAVINGS, CURRENT, ISA (case-insensitive)
     * @param currency    - optional, defaults to GBP. Allowed: GBP, USD, EUR (case-insensitive)
     * @return RateResponse (200) or ErrorResponse (400)
     */
    @GetMapping("/api/rates")
    public ResponseEntity<?> getRates(
            @RequestParam(required = false) String accountType,
            @RequestParam(required = false) String currency) {

        // Handle currency - default to GBP if blank or null
        if (currency == null || currency.isBlank()) {
            currency = "GBP";
        }
        currency = currency.toUpperCase();

        // ============================================================
        // TODO 1: Parse the accountType string into an AccountType enum
        // ============================================================
        // If accountType is null or blank, default to AccountType.CURRENT.
        // Otherwise, convert the string to uppercase and parse it.
        //
        // Hint: Use AccountType.valueOf(string) to convert a string to an enum.
        // But be careful - valueOf() throws IllegalArgumentException if the
        // string doesn't match any enum value.
        //
        // Steps:
        //   a) Check if accountType is null or blank -> set a default
        //   b) Try to parse it using AccountType.valueOf(accountType.toUpperCase())
        //   c) Wrap the valueOf() call in a try-catch block
        //
        // Declare a variable: AccountType type = ...
        // ============================================================
        AccountType type;


        // ============================================================
        // TODO 2: Return a 400 error if the accountType is invalid
        // ============================================================
        // If valueOf() threw an exception, return a 400 Bad Request with
        // an ErrorResponse containing:
        //   - error: "INVALID_ACCOUNT_TYPE"
        //   - message: "Allowed types: SAVINGS, CURRENT, ISA"
        //
        // Hint: Use ResponseEntity.badRequest().body(new ErrorResponse(...))
        // ============================================================


        // ============================================================
        // TODO 3: Get rate data for the account type
        // ============================================================
        // Call the getRateInfo() method below with the parsed type and currency.
        //
        // Hint: RateResponse response = getRateInfo(type, currency);
        // ============================================================


        // ============================================================
        // TODO 4: Return a 200 OK response with the RateResponse
        // ============================================================
        // Hint: Use ResponseEntity.ok(response)
        // ============================================================

        return null; // Replace this with your ResponseEntity
    }

    /**
     * Returns hardcoded rate information for the given account type.
     *
     * This is a helper method - not an endpoint. It just builds
     * a RateResponse object with the right data based on the account type.
     */
    private RateResponse getRateInfo(AccountType type, String currency) {
        String timestamp = Instant.now().toString();

        // ============================================================
        // TODO 5: Return hardcoded rate data based on the account type
        // ============================================================
        // Use a switch statement (or if-else) on the account type to return
        // a new RateResponse with the correct values:
        //
        //   SAVINGS: annualInterestRate = 1.5, minimumBalance = 500.00
        //   CURRENT: annualInterestRate = 0.1, minimumBalance = 0.00
        //   ISA:     annualInterestRate = 2.0, minimumBalance = 1000.00
        //
        // For all types, use:
        //   - type.name() for the accountType string
        //   - the currency parameter for currency
        //   - the timestamp variable for timestamp
        //
        // Hint: return new RateResponse(type.name(), 1.5, 500.00, currency, timestamp);
        //
        // Don't forget a default case that throws an exception (just in case).
        // ============================================================

        return null; // Replace this with your switch/if-else logic
    }
}

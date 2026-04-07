package com.training.banking.entity;

// ----------------------------------------------------------------
// TODO 1: Add the @Entity annotation to this class.
//
// This tells JPA "this class maps to a database table."
// Each field becomes a column. Each Account object becomes a row.
//
// You need to import: jakarta.persistence.Entity
//
// Add the annotation right above the class declaration.
// ----------------------------------------------------------------

// ----------------------------------------------------------------
// TODO 2: Add @Id and @GeneratedValue to the id field.
//
// @Id tells JPA "this field is the primary key."
// @GeneratedValue(strategy = GenerationType.IDENTITY) tells the
// database to auto-generate the ID (1, 2, 3, ...).
//
// You need to import:
//   jakarta.persistence.Id
//   jakarta.persistence.GeneratedValue
//   jakarta.persistence.GenerationType
//
// Add both annotations right above the "private Long id;" line.
// ----------------------------------------------------------------

public class Account {

    private Long id;

    private String accountNumber;

    private String holderName;

    private double balance;

    // JPA requires a no-arg constructor. It uses this when loading
    // objects from the database - it creates an empty object first,
    // then fills in the fields.
    public Account() {
    }

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

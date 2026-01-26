package com.chinmay.getlogic;

public class QuoteResponse {

    private String mood;
    private String quote;
    private String timestamp;

    public QuoteResponse(String mood, String quote, String timestamp) {
        this.mood = mood;
        this.quote = quote;
        this.timestamp = timestamp;
    }

    public String getMood() {
        return mood;
    }

    public String getQuote() {
        return quote;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

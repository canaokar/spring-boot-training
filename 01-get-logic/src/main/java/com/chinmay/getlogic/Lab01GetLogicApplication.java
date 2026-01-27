package com.chinmay.getlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import main.java.com.chinmay.getlogic.ErrorResponse;
import main.java.com.chinmay.getlogic.Mood;

import java.time.Instant;

@SpringBootApplication
@RestController
public class Lab01GetLogicApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab01GetLogicApplication.class, args);
    }

    // TODO: Implement GET /quote endpoint
    // Requirements:
    // - mood: optional query param. Allowed: happy, sad, motivated, tired
    // - default mood if missing: tired
    // - log: optional boolean query param, default false
    // - if log=true: print a single line to console: "Quote requested for
    // mood=<MOOD>"
    // - Success response: return QuoteResponse as JSON
    // - Invalid mood: return ErrorResponse as JSON (status 400)
    //
    // Constraints:
    // - NO Map usage
    // - DO NOT return String. Return QuoteResponse or ErrorResponse objects.
    // - Keep logic readable: no huge if-else chain.
    @GetMapping("/quote")
    public Object quote(
            @RequestParam(required = false) String mood,
            @RequestParam(required = false, defaultValue = "false") boolean log) {

        // TODO 1: convert input string -> Mood enum (case-insensitive)
        // Hint: if mood is null or blank -> Mood.TIRED
        // If invalid -> return new ErrorResponse("INVALID_MOOD", "...") with status 400

        // TODO 2: based on Mood, pick a quote string
        // Use a helper method: getQuoteForMood(Mood mood)

        // TODO 3: if log=true print to console

        // TODO 4: return new QuoteResponse(moodValue, quote, timestamp)
        // timestamp must be Instant.now().toString()

        return new ErrorResponse("NOT_IMPLEMENTED", "Complete the TODOs in /quote");
    }Student mood)
    {
        // Keep the quotes short and funny-ish.
        // Example:
        // HAPPY -> "Optimism: the only free subscription."
        // SAD -> "It’s okay. Even servers have downtime."
        // MOTIVATED -> "Ship it. Then fix it. Then ship it again."
        // TIRED -> "Coffee is just Java in liquid form."
        return "TODO";
    }

    // TODO: Implement this helper to parse mood safely (case-insensitive)
    // Rules:
    // - null/blank => Mood.TIRED
    // - "happy" => Mood.HAPPY
    // - invalid => return null (so controller can return 400)
    private Studentank => Mood.TIRED
    // - "happy" => Mood.HAPPY
    // - invalid => return null (so controller can return 400)
    private Mood parseMoodOrNull(String mood) {
        return null;
    }
}

# Lab 01 - GET Logic (Query Params + JSON + Errors)

## Objective
Implement a single endpoint that uses:
- query params
- default values
- optional logging
- JSON responses
- JSON error responses

This lab is intentionally small but strict.

---

## Endpoint to build

### GET /quote

#### Query params
- `mood` (optional): allowed values are `happy`, `sad`, `motivated`, `tired`
  - case-insensitive
  - if missing or blank -> default to `tired`
- `log` (optional boolean): default `false`
  - if `true`, print exactly:
    - `Quote requested for mood=<MOOD>`
    - where `<MOOD>` is the final parsed mood in uppercase (HAPPY/SAD/...)

#### Success (200)
Return JSON:
```json
{
  "mood": "tired",
  "quote": "Coffee is just Java in liquid form.",
  "timestamp": "2026-01-26T12:34:56Z"
}

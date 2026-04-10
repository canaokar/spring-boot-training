# Mini Project - Trip Weather Planner

## The story

You just moved to London for the grad program. Your family is back in Mumbai, your best mate is in Singapore, and you are already plotting a Christmas trip somewhere warm. Every week someone on the team is asking the same question: "Is it worth flying to Lisbon this weekend or will it rain the whole time?"

You decide to build a small backend service that answers trip planning questions. Given a city, it tells you the weather right now. Given a list of cities, it tells you which one is the most pleasant. Save the places you care about and get a one shot summary of everywhere you might want to be this weekend.

No banking. No spreadsheets. Just a fun little service that makes you look organised when the group chat starts planning the next trip.

---

## What you'll build

A backend only REST API that:

1. Looks up the current weather for any city in the world
2. Returns a multi day forecast for trip planning
3. Compares several cities at once and ranks them by "niceness"
4. Stores a list of favourite destinations in memory and returns a dashboard view of all of them
5. Gives a "should I pack an umbrella" style recommendation based on the forecast

All of this is powered by a real external API. No fake data.

---

## The external API: Open-Meteo

You will use [Open-Meteo](https://open-meteo.com/). It is free, needs no API key, and no sign up. It has two endpoints you will chain together.

### Step 1: Geocoding (turn a city name into coordinates)

```
GET https://geocoding-api.open-meteo.com/v1/search?name=London&count=1
```

Sample response (trimmed):
```json
{
  "results": [
    {
      "name": "London",
      "country": "United Kingdom",
      "latitude": 51.5085,
      "longitude": -0.1257,
      "timezone": "Europe/London"
    }
  ]
}
```

### Step 2: Forecast (use the coordinates to get weather)

```
GET https://api.open-meteo.com/v1/forecast?latitude=51.5085&longitude=-0.1257&current=temperature_2m,weather_code,wind_speed_10m&daily=temperature_2m_max,temperature_2m_min,precipitation_sum,weather_code&forecast_days=5&timezone=auto
```

Sample response (trimmed):
```json
{
  "current": {
    "temperature_2m": 14.3,
    "weather_code": 3,
    "wind_speed_10m": 12.1
  },
  "daily": {
    "time": ["2026-04-10", "2026-04-11", "2026-04-12"],
    "temperature_2m_max": [16.2, 18.5, 13.1],
    "temperature_2m_min": [8.4, 9.7, 7.2],
    "precipitation_sum": [0.0, 2.4, 8.1],
    "weather_code": [3, 61, 80]
  }
}
```

This is a real world pattern. Almost no weather API gives you a forecast from a city name directly. You geocode first, then call the forecast endpoint with the coordinates. This teaches you how to chain two external calls inside a single service method.

### Weather codes

The API returns numeric `weather_code` values. You will convert them to human readable descriptions with a small helper map. Give them icons if you want. A sample mapping:

```
0       Clear sky
1, 2, 3 Partly cloudy
45, 48  Foggy
51-57   Drizzle
61-67   Rain
71-77   Snow
80-82   Rain showers
95-99   Thunderstorm
```

---

## New concepts (building on lab 09)

Lab 09 made a single external call. This project pushes you further.

### 1. Chaining two external calls in one service method

You will make the geocoding call, read the latitude and longitude from the response, and then make a second call to the forecast endpoint. Both happen inside a single service method. If the first call fails or returns no results, the second call never happens and the service throws a meaningful error.

### 2. Parsing nested JSON into a real DTO

Lab 09 used `Map.class`. That works but gets ugly fast when the response has nested objects. In this project you will define proper DTO classes that mirror the API response structure, and let Spring deserialize into them:

```java
// Instead of Map<String, Object>, use a typed class:
GeoResponse geo = restTemplate.getForObject(geoUrl, GeoResponse.class);
ForecastResponse forecast = restTemplate.getForObject(forecastUrl, ForecastResponse.class);
```

You decide which fields you need and only include those in your DTO. Spring ignores the rest.

### 3. Transforming external data into your own shape

The Open-Meteo response is messy. Your API should return something clean that a frontend could use tomorrow without rework. You will write mapping code that takes the raw forecast and produces your own `WeatherSummary` and `DailyForecast` objects.

### 4. In memory favourites (no database yet)

You will keep a `List<String>` of favourite city names in a service. Add, remove, and list favourites. When someone asks for the favourites dashboard, you loop through the list, call the weather service for each, and return all the summaries in one response.

### 5. Simple business logic over API data

The "niceness score" and "umbrella recommendation" are not in the API. You compute them yourself from temperature and precipitation. This is the first time in the course you are doing real logic on top of data you fetched from somewhere else.

---

## Endpoints

| Method | Path | What it does |
|--------|------|--------------|
| GET | `/api/weather/current?city=London` | Current temperature, wind, and description for one city |
| GET | `/api/weather/forecast?city=London&days=5` | Daily max, min, rain, and description for the next N days |
| GET | `/api/weather/compare?cities=London,Lisbon,Dubai` | Rank a list of cities from nicest to worst for a trip |
| GET | `/api/weather/recommendation?city=London` | Returns a "pack an umbrella" style message based on the 3 day forecast |
| POST | `/api/favourites` | Add a city to the favourites list (body: `{ "city": "Lisbon" }`) |
| DELETE | `/api/favourites/{city}` | Remove a city from favourites |
| GET | `/api/favourites` | List favourite cities with current weather for each one |

---

## Suggested project structure

```
src/main/java/com/training/weather/
  WeatherApplication.java
  config/
    AppConfig.java                   (RestTemplate @Bean)
  controller/
    WeatherController.java
    FavouritesController.java
  service/
    WeatherService.java              (chains geocode then forecast)
    FavouritesService.java           (in memory list)
    RecommendationService.java       (niceness score, umbrella logic)
  client/
    dto/
      GeoResponse.java               (mirrors geocoding JSON)
      ForecastResponse.java          (mirrors forecast JSON)
  dto/
    WeatherSummary.java              (your clean shape)
    DailyForecast.java
    CityComparison.java
    FavouriteDashboardEntry.java
    ErrorResponse.java
```

You do not have to follow this exactly. Put things where they make sense to you, but keep controllers thin and push the real work into services.

---

## Niceness score (suggested formula)

The point is to rank cities for "would I rather be here this weekend". A possible formula:

```
score = 100
       - abs(averageMaxTemp - 22) * 2      (punish hot or cold, sweet spot 22C)
       - totalPrecipitation * 3            (rain is bad)
       - (windSpeed > 30 ? 10 : 0)         (windy days lose points)
```

Feel free to tune it. The learning is in writing a small, readable function that works on data you already shaped into your own DTO.

---

## Umbrella recommendation rules (suggested)

Look at the next 3 days in the forecast and return one of:

- `"Leave the umbrella at home"` when total rain across 3 days is under 1mm
- `"Worth packing a small umbrella"` when total rain is 1 to 10mm
- `"Do not forget a proper raincoat"` when total rain is 10mm or more
- `"Expect a storm, reconsider the trip"` when any weather code is in the thunderstorm range (95 to 99)

These are product decisions. Make them your own.

---

## How to test

Use a `.rest` file or curl. A good test flow:

```bash
# Current weather for London
curl "http://localhost:8080/api/weather/current?city=London"

# 5 day forecast for Lisbon
curl "http://localhost:8080/api/weather/forecast?city=Lisbon&days=5"

# Which city is best for a weekend trip?
curl "http://localhost:8080/api/weather/compare?cities=London,Lisbon,Dubai,Reykjavik"

# Should I bring an umbrella to Edinburgh?
curl "http://localhost:8080/api/weather/recommendation?city=Edinburgh"

# Build a favourites dashboard
curl -X POST "http://localhost:8080/api/favourites" -H "Content-Type: application/json" -d '{"city":"Mumbai"}'
curl -X POST "http://localhost:8080/api/favourites" -H "Content-Type: application/json" -d '{"city":"Singapore"}'
curl -X POST "http://localhost:8080/api/favourites" -H "Content-Type: application/json" -d '{"city":"Lisbon"}'
curl "http://localhost:8080/api/favourites"

# Error cases
curl "http://localhost:8080/api/weather/current?city=NotARealPlace"
curl "http://localhost:8080/api/weather/forecast?city=London&days=99"
```

---

## Done checklist

- [ ] App starts on port 8080 with no errors
- [ ] Current weather endpoint returns a clean JSON shape, not the raw Open-Meteo response
- [ ] Forecast endpoint returns the correct number of days with max, min, rain, and description
- [ ] Compare endpoint returns cities ordered by niceness score, highest first
- [ ] Recommendation endpoint returns one of the umbrella messages
- [ ] Adding a favourite returns 200 and the updated list
- [ ] Deleting a favourite that does not exist returns 404
- [ ] Favourites dashboard makes one API call per city and returns all summaries in one response
- [ ] Unknown city returns a 400 or 404 with a useful error message, not a stack trace
- [ ] Your service chains the geocoding call and the forecast call without leaking that detail to the controller
- [ ] You used typed DTOs, not `Map.class`, for at least one of the external calls

---

## Stretch goals

These are optional. No solution provided. Attempt any that sound fun.

1. **Packing list generator.** Given a city and a number of days, return a suggested packing list (jumper, shorts, umbrella, sunglasses) based on the forecast.
2. **Best day to fly.** For a single city, return which of the next 7 days has the best weather score.
3. **Surprise me.** Keep a small hardcoded list of "holiday worthy" cities and return whichever one has the best score today.
4. **Caching.** Cache forecast responses for 10 minutes so you do not hammer the API when someone refreshes their dashboard. Use a simple `Map<String, CachedEntry>`.
5. **Temperature units.** Accept a `units=imperial` query param and convert Celsius to Fahrenheit before returning.
6. **Weather emoji.** Map each weather code to an emoji and include it in the response.

---

## A nudge

The most common mistake on this project is trying to return the raw Open-Meteo JSON to the caller. Do not do that. Part of building a real backend is shaping messy upstream data into a clean contract your own clients can rely on. If the Open-Meteo response format changes tomorrow, only your mapping code should need to change, not the shape of your own API.

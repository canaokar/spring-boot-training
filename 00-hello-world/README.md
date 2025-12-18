```md
# 00 – Hello World (Spring Boot)

This module introduces the **absolute basics of a Spring Boot application**.  
The goal is to understand how a Spring Boot service starts and how a simple HTTP endpoint is exposed.

This folder is intentionally minimal.

---

## What This Module Covers

- Spring Boot project structure
- Application entry point (`main()` method)
- Embedded web server startup
- A basic REST endpoint using annotations
- Running a Spring Boot application locally

No additional frameworks or layers are introduced in this step.

---

## Project Structure

```

00-hello-world/
├─ pom.xml
└─ src/
└─ main/
└─ java/
└─ com/
└─ example/
└─ helloworld/
└─ HelloWorldApplication.java

````

---

## Key File

### `HelloWorldApplication.java`

This file:
- Bootstraps the Spring Boot application
- Starts an embedded web server
- Exposes a single HTTP GET endpoint at `/`

---

## How to Run

### Prerequisites
- Java 17
- Maven

Verify:
```bash
java -version
mvn -version
````

### Run Using Maven

```bash
mvn spring-boot:run
```

### Run from an IDE

* Open this folder in your IDE
* Run the `main()` method in `HelloWorldApplication`

---

## Test the Application

Once started, the application listens on port `8080`.

```bash
curl http://localhost:8080
```

Expected response:

```
Hello World from Spring Boot
```

---

## Notes

* This module uses no external configuration
* All logic is contained in a single file
* The endpoint returns plain text, not JSON
* Error handling, configuration, and layering are introduced in later modules

---

## Next Step

Proceed to the next folder to introduce request handling beyond a simple GET endpoint.

```
```

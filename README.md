```md
# Spring Boot Training

This repository contains a **progressive, hands-on Spring Boot backend training**.  
Each folder represents a single concept and is designed to be **run and understood independently**.

The training starts from a minimal Spring Boot application and incrementally introduces common backend patterns used in real-world Spring Boot services.

---

## Prerequisites

You will need:

- Java 17
- Maven
- An IDE (IntelliJ IDEA recommended)
- Basic understanding of HTTP and REST concepts

No prior Spring Boot experience is required.

---

## Repository Structure

Each subfolder is a standalone Spring Boot project.

```

spring-boot-training/
├─ 00-hello-world
├─ 01-post-request
├─ 02-external-api-call
├─ 03-query-params
├─ 04-middleware
├─ 05-route-validation
├─ 06-http-methods
├─ 07-mysql-basic
├─ 07.1-mysql-layer
├─ 08-jpa-intro
├─ 09-sql-relations
├─ 10-error-handling
├─ 11-json-web-token

````

Each folder contains:
- Its own `pom.xml`
- Source code under `src/main/java`
- Only the code required for the concept being demonstrated

There is no shared parent project by design.

---

## How to Run Any Step

You can run any folder independently.

### Option 1: Run from IDE (Recommended)
- Open the folder in your IDE
- Locate the `main()` method
- Run the application

### Option 2: Run using Maven
```bash
mvn spring-boot:run
````

### Option 3: Build and run the JAR

```bash
mvn clean package
java -jar target/*.jar
```

The application will start on port `8080` unless stated otherwise.

---

## Step 00: Hello World

**Folder:** `00-hello-world`

This step covers:

* Spring Boot project layout
* Application startup using `SpringApplication.run`
* Creating a basic REST endpoint
* Verifying the application using a browser or curl

Expected response:

```bash
curl http://localhost:8080
```

```
Hello World from Spring Boot
```

---

## Training Guidelines

* Work through the folders in order
* Do not skip steps
* Focus on understanding structure before adding features
* Keep each example minimal and runnable

---

## Notes

* Java version is fixed at 17
* Spring Boot version is pinned per folder
* Examples are intentionally minimal
* This repository is designed for training, not as a production template

---

## License

For training and educational use only.

```
```

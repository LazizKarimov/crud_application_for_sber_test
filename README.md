# CRUD Application (Java)

This is a CRUD (Create, Read, Update, Delete) application built using Java Spring Boot. 
It provides basic CRUD operations for managing Director and Movie entities.

## Features

- **Create:** Add new entity.
- **Read:** View all entities in the collection or search for specific entity.
- **Update:** Edit existing entity in the collection.
- **Delete:** Remove entity from the collection.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **H2 (for testing)**
- **REST API**
- **Slf4j**
- **JavaDoc commentary**

## Getting Started

To get started with the CRUD application, follow these steps:

1. Clone this repository.
2. Set up the database:
    - Create a PostgreSQL database (you can find scripts in /resources directory).
    - Configure the database connection in `application.yml`.
3. Run the Spring Boot application.

## API Endpoints

The backend provides the following RESTful API endpoints:

- **GET /movie:** Get all movies.
- **POST /movie:** Create a new movie.
- **GET /movie/{id}:** Get a specific movie by ID.
- **PUT /movie/{id}:** Update a movie by ID.
- **DELETE /movie/{id}:** Delete a movie by ID.

- **GET /director:** Get all directors.
- **POST /director:** Create a new director.
- **GET /director/{id}:** Get a specific director by ID.
- **PUT /director/{id}:** Update a director by ID.
- **DELETE /director/{id}:** Delete a director by ID.

## Usage

Send HTTP requests to the API endpoints using tools like Postman.
- <img src="src/main/resources/Снимок экрана 2024-02-23 в 11.35.05.png" alt="Alt текст" width="600" height="300">



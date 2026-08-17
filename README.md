# Employee Management System

## Overview

Employee Management System is a Spring Boot application developed to manage employee information and payroll operations through RESTful APIs.

The application uses Spring Data JPA for database persistence and Hibernate as the JPA implementation. It follows a layered architecture with separate Controller, Service, Repository, and Model layers.

The application provides APIs for employee management, salary calculation, and payroll management.

## Features

* Add employee
* Get employee by ID
* Get all employees
* Update employee details
* Delete employee
* Search employees by name
* Calculate employee salary
* Generate payroll
* Get employee payroll details
* Get payroll history
* Delete payroll records
* RESTful API implementation
* Database persistence using Spring Data JPA
* Exception handling
* Request and response handling using JSON
* Input validation

## Technologies Used

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java            | Application development         |
| Spring Boot     | Application framework           |
| Spring Web      | REST API development            |
| Spring Data JPA | Data access and persistence     |
| Hibernate       | JPA implementation and ORM      |
| PostgreSQL      | Database                        |
| Maven           | Build and dependency management |
| REST API        | Client-server communication     |
| JSON            | Data exchange                   |
| Git             | Version control                 |
| GitHub          | Source code management          |

## Architecture

The application follows a layered architecture:

```text
Client
   |
   v
Controller
   |
   v
Service
   |
   v
Repository
   |
   v
Spring Data JPA
   |
   v
Hibernate
   |
   v
PostgreSQL Database
```

### Controller Layer

The Controller layer handles HTTP requests and maps REST API endpoints to the corresponding service methods.

### Service Layer

The Service layer contains the application's business logic. It acts as an intermediate layer between the Controller and Repository layers.

### Repository Layer

The Repository layer is responsible for database operations. Spring Data JPA repositories are used to perform persistence operations without writing traditional JDBC code.

### Model Layer

The Model layer contains the JPA entity classes that represent the application's database tables.

## Employee Use Cases

| ID    | Use Case          | Endpoint                        | Method |
| ----- | ----------------- | ------------------------------- | ------ |
| UC-01 | Add Employee      | `/employees`                    | POST   |
| UC-02 | Get Employee      | `/employees/{id}`               | GET    |
| UC-03 | Get All Employees | `/employees`                    | GET    |
| UC-04 | Update Employee   | `/employees/{id}`               | PUT    |
| UC-05 | Delete Employee   | `/employees/{id}`               | DELETE |
| UC-06 | Search Employee   | `/employees/search?name={name}` | GET    |

### Add Employee

```http
POST /employees
```

Creates a new employee and stores the employee details in the database.

### Get Employee

```http
GET /employees/{id}
```

Retrieves an employee using the employee ID.

### Get All Employees

```http
GET /employees
```

Retrieves all employees from the database.

### Update Employee

```http
PUT /employees/{id}
```

Updates the details of an existing employee.

### Delete Employee

```http
DELETE /employees/{id}
```

Deletes an employee using the employee ID.

### Search Employee

```http
GET /employees/search?name={name}
```

Searches for employees based on their name.

## Salary and Payroll Use Cases

| ID    | Use Case             | Endpoint                  | Method |
| ----- | -------------------- | ------------------------- | ------ |
| UC-07 | Calculate Salary     | `/employees/{id}/salary`  | GET    |
| UC-08 | Generate Payroll     | `/payroll`                | POST   |
| UC-09 | Get Employee Payroll | `/employees/{id}/payroll` | GET    |
| UC-10 | Get Payroll History  | `/payroll/history`        | GET    |
| UC-11 | Delete Payroll       | `/payroll/{id}`           | DELETE |

### Calculate Salary

```http
GET /employees/{id}/salary
```

Calculates the salary for the specified employee based on the application's salary calculation logic.

### Generate Payroll

```http
POST /payroll
```

Generates payroll information based on employee salary details.

### Get Employee Payroll

```http
GET /employees/{id}/payroll
```

Retrieves payroll information for a specific employee.

### Get Payroll History

```http
GET /payroll/history
```

Retrieves the payroll history maintained by the application.

### Delete Payroll

```http
DELETE /payroll/{id}
```

Deletes a payroll record using its ID.

## API Summary

### Employee APIs

| Method | Endpoint                        | Description       |
| ------ | ------------------------------- | ----------------- |
| POST   | `/employees`                    | Add employee      |
| GET    | `/employees/{id}`               | Get employee      |
| GET    | `/employees`                    | Get all employees |
| PUT    | `/employees/{id}`               | Update employee   |
| DELETE | `/employees/{id}`               | Delete employee   |
| GET    | `/employees/search?name={name}` | Search employee   |

### Salary and Payroll APIs

| Method | Endpoint                  | Description          |
| ------ | ------------------------- | -------------------- |
| GET    | `/employees/{id}/salary`  | Calculate salary     |
| POST   | `/payroll`                | Generate payroll     |
| GET    | `/employees/{id}/payroll` | Get employee payroll |
| GET    | `/payroll/history`        | Get payroll history  |
| DELETE | `/payroll/{id}`           | Delete payroll       |

## Spring Data JPA

The application uses Spring Data JPA to simplify database operations.

Instead of manually managing:

```text
Connection
PreparedStatement
ResultSet
SQL Queries
Connection Closing
```

Spring Data JPA provides repository interfaces that allow the application to perform database operations using methods such as:

```java
save()
findById()
findAll()
deleteById()
```

Custom query methods can also be created based on the application's requirements.

## Hibernate

Hibernate is used as the JPA implementation.

The relationship between the technologies is:

```text
Spring Boot
     |
     v
Spring Data JPA
     |
     v
JPA
     |
     v
Hibernate
     |
     v
JDBC
     |
     v
PostgreSQL
```

Spring Data JPA provides the repository abstraction, while Hibernate handles the actual ORM and database interaction.

## Entity Mapping

The application uses JPA annotations to map Java classes to database tables.

Common annotations include:

```java
@Entity
@Table
@Id
@GeneratedValue
@Column
```

These annotations allow Hibernate to map Java objects to relational database tables.

## Exception Handling

The application handles errors using custom exceptions and centralized exception handling.

This allows the application to return meaningful HTTP responses when situations such as the following occur:

* Employee not found
* Invalid employee ID
* Invalid request data
* Database-related errors
* Unexpected application errors

## Validation

Input validation can be applied to incoming employee and payroll requests to ensure that the provided data satisfies the application's requirements before processing it.

Common validation annotations include:

```java
@NotNull
@NotBlank
@Size
@Email
@Positive
```

## Database

The application uses PostgreSQL as the relational database.

Spring Data JPA and Hibernate are responsible for persistence between the Java application and PostgreSQL database.

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_management
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Update the database name, username, and password according to your local PostgreSQL configuration.

## Project Structure

```text
EmployeeManagementSystem
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.bridgelabz.EmployeeManagementSystem
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── model
│   │   │       ├── exception
│   │   │       └── EmployeeManagementSystemApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

## Prerequisites

Before running the application, make sure the following are installed:

* JDK 17 or later
* Maven
* PostgreSQL
* IntelliJ IDEA, Eclipse, or Spring Tool Suite
* Postman or another REST API testing tool

## Running the Application

### 1. Clone the Repository

```bash
git clone https://github.com/PalagiriNagayogeswari/EmployeeManagementSystem.git
```

### 2. Navigate to the Project

```bash
cd EmployeeManagementSystem
```

### 3. Configure PostgreSQL

Create the required PostgreSQL database.

### 4. Configure Database Credentials

Update `application.properties` with your PostgreSQL database URL, username, and password.

### 5. Build the Application

```bash
mvn clean install
```

### 6. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

### 7. Test the APIs

Use Postman or another REST API client to test the employee and payroll endpoints.

## Example Employee Request

```http
POST /employees
Content-Type: application/json
```

Example request body:

```json
{
    "name": "John Doe",
    "email": "john.doe@example.com"
}
```

The exact request fields should match the Employee entity implemented in the application.

## Concepts Demonstrated

This project demonstrates practical implementation of:

* Java
* Spring Boot
* Spring Web
* REST API development
* Dependency Injection
* Inversion of Control
* Layered architecture
* Controller-Service-Repository pattern
* Spring Data JPA
* JPA
* Hibernate
* ORM
* PostgreSQL
* Entity mapping
* CRUD operations
* Derived query methods
* Custom exceptions
* Global exception handling
* Bean validation
* Maven
* JSON request and response handling
* REST API testing using Postman
* Git and GitHub

## Future Enhancements

Possible enhancements include:

* Pagination and sorting
* Advanced employee search
* Swagger/OpenAPI documentation
* Authentication and authorization
* Unit testing
* Integration testing
* Role-based access control
* Docker support
* API documentation

## Author

**Palagiri Nagayogeswari**

GitHub: https://github.com/PalagiriNagayogeswari


This project is developed for learning and educational purposes.

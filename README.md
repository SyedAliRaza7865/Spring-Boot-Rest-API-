Employee Management REST API

A simple REST API built using Java and Spring Boot to manage employee records.

Features
- Add a new employee
- Retrieve all employees
- Search an employee by ID
- Update employee details
- Delete an employee by ID
- Handle employee not-found responses

Technologies
- Java
- Spring Boot
- Spring Web
- Postman

API Endpoints

| Method | Endpoint | Operation |
|---|---|---|
| POST | `/employees` | Add employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |

How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run `SpringBoot2Application.java`.
4. Test the endpoints using Postman at `http://localhost:8080`.

Note
Employee records are stored in an in-memory list. No database is required, and data resets when the application restarts.

Author
Syed Ali Raza

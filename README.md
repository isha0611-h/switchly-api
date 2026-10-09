# Switchly API

A REST API built with Java and Spring Boot for managing organizations and projects.

## About the Project

Switchly API is a backend application that provides REST endpoints to create and manage organizations and projects. It demonstrates the fundamentals of backend development, RESTful APIs, HTTP methods, and CRUD operations.

## Technologies Used

- **Java 21** — Programming language
- **Spring Boot** — Backend framework
- **Maven** — Project and dependency management
- **Spring Web** — Building REST APIs
- **Jakarta Validation** — Request validation
- **IntelliJ IDEA** — Development environment
- **Git and GitHub** — Version control and code hosting

## Features

- Create an organization
- Create a project associated with an organization
- Retrieve all projects
- Retrieve a project by its ID
- Retrieve projects by organization
- Update project details
- Delete a project
- Validate incoming request data
- Handle API errors, including not-found responses

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/orgs` | Create an organization |
| POST | `/api/v1/projects` | Create a project |
| GET | `/api/v1/projects` | Retrieve all projects |
| GET | `/api/v1/projects/{projectId}` | Retrieve a project by ID |
| GET | `/api/v1/projects/by-organization/{organizationId}` | Retrieve projects by organization |
| PUT | `/api/v1/projects/{projectId}` | Update a project |
| DELETE | `/api/v1/projects/{projectId}` | Delete a project |

## Example Request

### Create a Project

**POST** `/api/v1/projects`

Request body:

```json
{
  "organizationId": "YOUR-ORGANIZATION-UUID",
  "name": "My First Project"
}
```

Replace `YOUR-ORGANIZATION-UUID` with the actual ID returned when you create an organization.

## How to Run the Project

1. Install Java 21 or a compatible configured JDK.
2. Install IntelliJ IDEA.
3. Clone or download this repository.
4. Open the project in IntelliJ IDEA.
5. Allow Maven to load the dependencies.
6. Run the `ApiApplication` class.
7. Send requests using `requests.http` or an API client.

The API runs at `http://localhost:8080` by default.

## Data Storage

The current version uses in-memory storage. Data is not permanently saved, so organizations and projects may be lost when the application restarts.

## Future Improvements

- Add a persistent database.
- Add authentication and authorization.
- Improve automated testing.
- Add API documentation with Swagger/OpenAPI.
- Add deployment support.

## Author

**Your Name**

## License

This project is currently available for learning and portfolio purposes. A formal open-source license can be added later.

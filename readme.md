## Project Setup & Dependencies:
* Spring Web – enables building RESTful APIs and handling HTTP requests/responses.
* MySQL Driver – connects the application to a MySQL database.
* JPA (Java Persistence API) – simplifies database interactions through ORM (Object Relational Mapping).
* Lombok – reduces boilerplate code by auto-generating getters, setters, constructors, etc.
* Validation – ensures that incoming user data meets defined constraints before processing.

## Core Functionality – CRUD Operation:
* Users can create accounts with a strict rule: one email per account, and all personal data are immutable once registered with the exception of password.
* Account creation timestamps are automatically recorded, enabling the company to track user onboarding activity.
* The system supports fetching all users, as well as retrieving individual users via an auto-generated primary key (ID).
* Users can update only their passwords.
* The company can delete inactive user accounts from the system.

## Structured Response Handling:
* success (boolean)
* message (descriptive feedback)
* data (payload) (actual response content)
* status (HTTP status code)

## Custom Exception Handling:
To improve reliability and user experience, I implemented custom exceptions that guide users through the banking process and enforce business rules effectively.


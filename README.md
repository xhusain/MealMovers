# MealMovers

MealMovers is a full-stack web-based food ordering application built with
Java, Spring MVC, JSP, CSS, and MySQL. The application demonstrates the
complete flow from a browser-based user interface through backend controllers
and business services to persistent database storage.

MealMovers allows customers to browse restaurants and menus, add items to a
cart, place orders, and view order details. It also provides owner-facing
functionality for managing restaurant and order information.

## Features

- User registration and login
- Restaurant listing and menu browsing
- Add and remove items from a shopping cart
- Order placement and order summary
- User dashboard
- Owner dashboard
- Restaurant, menu, and order management
- Session-based user access

## Full-stack technology stack

### Frontend

- JSP and JSTL
- HTML
- CSS
- Session-based user interface flows

### Backend

- Java 11
- Spring MVC 5
- Spring JDBC
- Controllers, services, DAOs, and domain models

### Database and deployment

- MySQL
- Apache Maven
- Apache Tomcat
- WAR packaging

## Project structure

```text
src/main/java/       Backend controllers, services, DAOs, and models
src/main/resources/  Backend application resources
src/main/webapp/     Frontend JSP views, CSS, images, and web configuration
pom.xml              Full-stack Maven dependencies and build configuration
JENKINS.md           Jenkins build and Tomcat deployment documentation
```

## Prerequisites

- Java Development Kit (JDK) 11
- Apache Maven 3.6 or newer
- MySQL 8
- Apache Tomcat 9

## Database configuration

MealMovers expects a MySQL database named `meal_movers`. The application
requires the following environment variables at startup:

| Variable | Description |
|---|---|
| `DB_URL` | JDBC URL, including the database name and TLS parameters |
| `DB_USERNAME` | Least-privilege MySQL application user |
| `DB_PASSWORD` | Password for the MySQL application user |

Example for a local MySQL instance:

```text
DB_URL=jdbc:mysql://localhost:3306/meal_movers?useSSL=true&requireSSL=true&serverTimezone=UTC
DB_USERNAME=meal_movers_app
DB_PASSWORD=use-a-local-secret
```

The database user should not be MySQL `root`, and real credentials should never
be committed to Git. The project intentionally fails to start when these
required settings are missing rather than using unsafe credential defaults.
The database schema must be created separately before the application is run.

## Building and deploying the project

This project is packaged as a WAR application. With Java 11 and Maven
installed, run:

```bash
mvn clean package
```

The generated application archive is:

```text
target/mealmovers.war
```

The WAR can be deployed to a compatible Apache Tomcat 9 installation. The
application context path is typically `/mealmovers`, depending on the Tomcat
deployment configuration.

## Security

User passwords are hashed with BCrypt before they are stored. User-controlled
values rendered in JSP views use JSTL escaping to reduce cross-site scripting
risk. Production deployments should use HTTPS, a least-privilege database
account, protected environment variables, and a properly configured TLS
certificate for the database connection.

## Jenkins

The project was previously built, packaged, and deployed through Jenkins using
Maven and Apache Tomcat. The Maven lifecycle includes its test phase, although
the repository currently has no automated test sources. Details of that
process are documented in [JENKINS.md](JENKINS.md).

## Project context

MealMovers was developed as a software construction and development project to
demonstrate full-stack web application design, database integration, Maven WAR
packaging, and Jenkins-based deployment.

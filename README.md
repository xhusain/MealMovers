# MealMovers

MealMovers is a full-stack web-based food ordering application built with
Java, Spring MVC, JSP, CSS, and MySQL. It includes the complete application
flow from the browser-based user interface through backend controllers and
business services to persistent database storage.

Users can browse restaurants and menus, add items to a cart, place orders, and
view order details. The application also includes owner-facing functionality
for managing restaurant and order information.

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

## Building the project

This project is packaged as a WAR application. With Java 11 and Maven
installed, run:

```bash
mvn clean package
```

The generated application archive is:

```text
target/mealmovers.war
```

## Database

The application uses MySQL with a database named `meal_movers`. Database
connection settings are defined in the Spring web configuration and should be
updated for the local development environment.

Do not commit real database passwords or other credentials to the repository.

## Jenkins

The project was previously built and deployed through Jenkins using Maven and
Apache Tomcat. Details of that process are documented in
[JENKINS.md](JENKINS.md).

## Author

MealMovers was developed as a software construction and development project.

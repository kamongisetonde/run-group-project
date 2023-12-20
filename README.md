# Running Group Web App

HERE IS MY PDF DOCUMENTATION FOR MORE DETAILS: https://github.com/kamongisetonde/Documentation_RunGroopApp/blob/main/Web%20Technology%20Final%20Documentation.pdf

![Java](https://img.shields.io/badge/Java-%3E%3D8-brightgreen) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen) ![Hibernate](https://img.shields.io/badge/Hibernate-5.5.6-brightgreen) ![MySQL](https://img.shields.io/badge/MySQL-8.0-brightgreen) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0-brightgreen)

## Overview
The Running Group Web App is a Spring Boot application that enables users to create accounts, log in, and interact with various running clubs. Users can explore running events hosted by different clubs and sign up for events they are interested in.

## Technologies Used
- **Java**
- **Spring Boot**: Framework for creating Java-based, enterprise-grade applications.
- **Hibernate**: Object-relational mapping framework for Java applications.
- **MySQL**: Open-source relational database management system.
- **Thymeleaf**: Modern server-side Java template engine for web and standalone environments.

## How to Run the Project

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server
- Your favorite IDE (IntelliJ, Eclipse, etc.)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/running-group-web-app.git

2. Configure MySQL database:

Create a MySQL database and update the src/main/resources/application.properties file with the database connection details.
properties
```Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
Open the project in your IDE.
```
### Run the application:

Build and run the project using your IDE or use the following Maven command:
bash
```Copy code
./mvnw spring-boot:run
```
Access the application:

Open a web browser and go to ```http://localhost:8080.```
Usage
Create a new account or log in if you already have one.
Explore the list of running clubs and their events.
Sign up for events you are interested in.
Deployment (Render.com)
To deploy this application on Render.com, follow these steps:

Render.com url: 

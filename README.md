# Kata Agregio

An API for managing energy sales by Agregio across various markets.
It allows creating offers with different energy quantities and prices for primary, secondary, and rapid reserves.
Additionally, it facilitates listing offers per market and retrieving the parks selling energy on a specific market

# Technologies

The project uses the following technologies:

    Java
    Spring Framework
    Spring Boot
    Hibernate
    JPA Repository
    Swagger
    Docker
    Flyway

# Setup

To run the project locally, you need to have the following software installed on your machine:

    Java Development Kit (JDK)
    Docker

Follow these steps to set up the project:

1. Clone the repository:

       git clone git@gitlab.takima.io:wbensidhoum/kata-agregio.git 

2. Navigate to the project directory:

        cd kata-agregio

3. Configure environment variables:

       cp .env.sample .env

   Modify the .env file to adjust configurations if necessary.

4. Database Setup

   Ensure Docker is installed and running.
   Run the following command to start PostgreSQL:

       docker-compose up -d

5. Running the Application

   Build and run the application with Maven:

       mvn clean install
       mvn spring-boot:run

The application will be available at http://localhost:8080.

### API Documentation

API endpoints are documented via Swagger. Once the application is running, access http://localhost:8080/swagger-ui.html
to explore and test the endpoints.

### DB-Adminer

A DB-Adminer for the database is available at http://localhost:18080/.

## Authors

Wissem Bensidhoum
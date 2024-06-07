# weather-service

## Description

Weather service is a Spring Boot application that displays the current temperatures for a set of cities. It uses the OpenWeatherMap API to fetch the weather data and provides a RESTful API to interact with the data. The application initializes with 100 city names, queries their current temperatures, and stores them in an H2 database. The API includes endpoints to see results, delete all results, and query new temperatures. It also supports sorting and paging functionalities.

## Prerequisites

- Java 21
- Maven
- Docker (optional, if running in a Docker container)
- OpenWeatherMap API Key

## Running the Application

### As a Standalone Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/VladFernoaga/weather-service.git
   ```
   ```bash
     cd weather-service
   ```
2. **Set the OpenWeatherMap API Key**

   ```bash 
   export OPENWEATHERMAP_API_KEY=your_api_key_value
   ```
3. **Build the Application**

Use Maven to build the application:

```bash
./mvnw clean package
```
4. **Run the Application**

After building, run the application using the following command:

```bash
java -jar target/weather-service-0.0.1-SNAPSHOT.jar
```

## In a Docker Container
1. **Build the Docker Image**

Make sure you have Docker installed and running. Then build the Docker image using the following command:

```bash
docker build -t weather-service:1.0.0 .
```

2. **Run the Docker Container**

Run the container using the following command, passing the OpenWeatherMap API key as an environment variable:

```bash
docker run -p 8080:8080 -e "OPENWEATHERMAP_API_KEY=your_api_key_value" weather-service:1.0.0
```
## Access the API

The application will be accessible at `http://localhost:8080`.

To access the Swagger UI for API documentation and testing, navigate to `http://localhost:8080/swagger-ui.html`.


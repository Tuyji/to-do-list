# to-do-list-service
Simple to-do-list rest application with spring boot.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system
* [Lombok](https://projectlombok.org/) - Java library that automatically plugs into your editor and build tools, spicing up your java.
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [JUnit5](https://junit.org/junit5/) - JUnit 5 is the next generation of JUnit. The goal is to create an up-to-date foundation for developer-side testing on the JVM
* [Mockito](https://site.mockito.org/) - Tasty mocking framework for unit tests in Java
* [Docker](https://hub.docker.com/) - Containerization of applications
* [Couchbase](https://www.couchbase.com/) - The Modern Database for Enterprise Applications



## Running the application locally


- Download the zip or clone the Git repository.
- Import Maven projects
- Run to-do-list service


## Running the application with docker

- docker pull tuyji/todolist
- docker run --name todolist -d -p 8080:8080 todolist:latest


### URLs

|  URL | Remark |
|----------|--------------|
|`http://localhost:8080/api/todolist`                 | To-Do-List API |
|`http://localhost:8080/swagger-ui.html`              | Swagger Impl |





## Sample Images & Documentation





### Swagger UI


#### To-Do-List API Swagger Documentation

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/to-do-list/blob/main/src/main/resources/images/swaggerCapture.PNG)]()




#### Postman Collection


* [to-do-list.postman_collection.json](https://github.com/Tuyji/to-do-list/blob/main/src/main/resources/ToDoList.postman_collection.json)



[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/to-do-list/blob/main/src/main/resources/images/postmanCapture.PNG)]()




#### Unit Tests & Test Coverage


[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/to-do-list/blob/main/src/main/resources/images/coverageCapture.PNG)]()




## packages

- `config` — swagger config;
- `service` — business logic holder;
- `controller` — rest api implementations;
- `exception` — custom error handling and exceptions;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties (server, proxy, url, database configrations) .

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies

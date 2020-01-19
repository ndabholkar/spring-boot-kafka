# spring-boot-kafka
Apache Kafka Producer / Consumer demo using Spring Boot

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/maven-plugin/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#production-ready)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-kafka)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

### Docker commands
```
docker network create app-tier --driver bridge
docker run -d --name zookeeper-server --network app-tier -e ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper:latest
docker run -d --name kafka-server --network app-tier -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 -p 9092:9092 bitnami/kafka:latest
```

Add entry for IP address of the Kafka server to the /etc/hosts file of the application

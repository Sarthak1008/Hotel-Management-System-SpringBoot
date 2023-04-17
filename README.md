# Hotel-Management-System-SpringBoot
This is a SpringBoot project about Hotel Management System

A Hotel Management System made using Spring Boot is a software application that allows hotel managers to manage their day-to-day operations efficiently. This system is designed using various technologies such as API Gateway, configuration on GitHub, Eureka client dependencies, and three data files, namely hotels, their rating, and the users who rated them.

API Gateway is used to provide a single entry point for all the microservices in the system. Configuration on GitHub is used to store the configuration files of the system, which can be updated easily without the need for a restart. Eureka client dependencies are used for service registration and discovery.

The system is divided into three separate microservices, one for each data file. The first microservice manages the hotels and their information, the second microservice manages the ratings of the hotels, and the third microservice manages the users who rated the hotels. These microservices communicate with each other using REST APIs.

The API Gateway acts as the front-end for the system, providing a unified interface to the user. It routes the user's request to the appropriate microservice based on the request URL.

Overall, this Hotel Management System made using Spring Boot provides a scalable and efficient solution for managing hotels, their ratings, and the users who rate them.

The Project consist of 4 microservices(question-microservice | quiz-microservice | service-registry | api-gateway)

1. Question Microservice
Description: This microservice is responsible for managing and retrieving quiz-related data from the database. It provides endpoints to fetch questions based on various criteria, such as quiz type, difficulty level, and subject. The service ensures that the data is properly formatted and ready for consumption by other microservices or client applications.
Key Features:
Database Interaction: Connects to a backend database to perform CRUD operations on quiz data.
Endpoints: Provides RESTful endpoints to fetch questions.
Data Validation: Ensures data integrity and validation before sending it to the requester.


2. Quiz Microservice
Description: This microservice generates quizzes and calculates quiz results by interacting with the Question Microservice. It is responsible for assembling quizzes based on specific requirements and evaluating user responses to generate a score or result.
Key Features:
Quiz Generation: Calls the Question Microservice to fetch relevant questions and compile them into a quiz.
Result Calculation: Processes user answers and calculates the quiz results.
Business Logic: Contains the logic for quiz generation, such as randomization of questions and inclusion of different question types.


3. API Gateway
Description: The API Gateway serves as the single entry point for all client requests. It routes incoming requests to the appropriate microservice and handles common concerns such as authentication, logging, and rate limiting. This layer simplifies the interaction between clients and the backend services by providing a unified interface.
Key Features:
Request Routing: Forwards client requests to the appropriate microservice.
Authentication and Authorization: Manages security and access control.
Rate Limiting: Controls the rate of incoming requests to prevent overloading the system.
Logging and Monitoring: Tracks and logs requests for monitoring and debugging purposes.


4. Service Registry
Description: The Service Registry uses Eureka Server to register all microservices, making them discoverable and accessible to each other regardless of their individual network locations or port numbers. This enables dynamic service discovery and facilitates the scaling and management of the microservices.
Key Features:
Service Registration: Registers each microservice with the Eureka Server upon startup.
Service Discovery: Allows microservices to discover each other dynamically, enabling them to call one another without hardcoding their locations.
Health Monitoring: Monitors the health of registered services and updates their status in the registry.
Load Balancing: Distributes client requests across multiple instances of a microservice, if available.

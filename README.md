# Customer Springboot Application

This project is a customer management system that consists of a back-end application built with Spring Boot and a front-end application built with React. The back-end application provides RESTful web services that allow users to manage customer data, such as phone number and country, while the front-end application provides a user-friendly interface to interact with the back-end application.

## Back-End Part

The back-end application is responsible for loading the database and running filtration based on the state of the phone number and countryPhoneRegex. It leverages the following components:

* [Spring Framework](https://spring.io/projects/spring-framework)
* [Java util Regex](https://docs.oracle.com/javase/7/docs/api/java/util/regex/package-summary.html)

### Screenshots

![Screenshot 1](screenshots/spring_app_run.JPG)
![Screenshot 2](screenshots/running_1.JPG)
![Screenshot 3](screenshots/running_2.JPG)

### How to run the application

To run the back-end application, follow these steps:

1. Load the file on IntelliJ IDE or any preferred IDE.
2. Run the application.

To run the back-end application using Docker, follow these steps:

1. Build the Docker image: `docker build -t 8090:8090 customer-sql-springboot:v1`.
2. Run the Docker container: `docker run -p 8090:8090 customer-sql-springboot:v1`.

## Front-End Part

The front-end application is responsible for providing a user-friendly interface to interact with the back-end application. It was built using React and communicates with the back-end application using RESTful API calls.

### Screenshots

![Screenshot 1](springboot-react-frontend/screenshots/Capture.JPG)
![Screenshot 2](springboot-react-frontend/screenshots/Capture1.JPG)

### How to run the application

To run the front-end application, follow these steps:

1. Install the dependencies: `npm install`.
2. Start the development server: `npm run start`.
3. Open [http://localhost:3000](http://localhost:3000) to view the application in the browser.

To run the front-end application using Docker, follow these steps:

1. Build the Docker image: `docker build -t 3000:3000 springbootreactfrontend`.
2. Run the Docker container: `docker run -p 3000:3000 springbootreactfrontend`.

Enjoy using the Customer Springboot Application!

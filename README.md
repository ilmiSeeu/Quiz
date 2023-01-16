# Quiz Project

#### Introduction:
The goal of this project is to create a quiz application that allows students to take quizzes and professors to create and manage quizzes. The application will have the following main features:


1. Quiz creation and management by professors
2. Quiz taking by students
3. Leaderboard to display top-performing students


#### Technical details:

The application will be built using Spring Boot, a popular Java framework for building web applications. The application will use a MySQL database to store user information and quiz data. The application will use Spring Data JPA for database access and management


#### Dependencies:

- Java 8 or higher
- Spring Boot 2.4.0 or higher
- MySQL 8.0 or higher
- Spring Data JPA
- Spring Web
- MySQL Driver
- junit:4.13.1


#### Documentation:

1. To run the application, make sure you have Java 8 or higher installed on your machine.
2. Download the project and import it into Inellij IDEA.
3. Make sure to add the necessary dependencies to your project.
4. Run the project by running the main class JavaProApplication.java
5. The application will be available at http://localhost:8080/
6. The application should now be running, test the REST endpoints using a tool such as Insomnia or Postman
7. To create a new student, send a POST request to http://localhost:8080/students with a JSON body containing the student's name
8. To retrieve a list of all students send a GET request to http://localhost:8080/students or to retrieve a specific student by ID with http://localhost:8080/students/{student_id}
9. To delete a student, send a DELETE request to http://localhost:8080/students/{id}.
10. To create a new professor, send a POST request to http://localhost:8080/professors with a JSON body containing the professor's name
11. To retrieve a list of all professor send a GET request to http://localhost:8080/professors or to retrieve a specific professor by ID with http://localhost:8080/professors/{professor_id}
12. To delete a professor, send a DELETE request to http://localhost:8080/professors/{id}.
13. To create a new question, send a POST request to http://localhost:8080/questions?id={professor_id} with a JSON body containing the question text and answer.
14. To edit a question send a Post request to http://localhost:8080/questions/{question_id}?professorId={professor_id}
15. To delete a question, send a DELETE request to http://localhost:8080/questions/{question_id}?professorId={professor_id}
16. To retrieve a list of all questions send a GET request to http://localhost:8080/questions or to retrieve a specific questions by ID with http://localhost:8080/questions/{question_id}
17. To answer a question send a POST request to http://localhost:8080/students/answers?studentId={student_id}&questionId={question_id} with a JSON body containing the student's answer
18. To retrieve the sorted leaderboard send a GET request to http://localhost:8080/leaderboard/rank
19. To retrieve the student by rank in the leaderboard send a GET request to http://localhost:8080/leaderboard/{rank_index}
20. To retrieve the student rank in the leaderboard but student ID send a GET request to http://localhost:8080/leaderboard/rank/{student_id}


It is important to thoroughly test the application before deployment to ensure that all features are working as intended and that there are no bugs or errors present. This can be done by running the application locally and manually running the JUnit test in the test folder I have made

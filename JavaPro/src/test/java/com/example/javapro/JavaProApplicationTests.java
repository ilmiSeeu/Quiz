package com.example.javapro;
import com.example.javapro.pojo.*;
import com.example.javapro.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaProApplicationTests {
    @Autowired
    StudentService studentService;

    @Test
    void testStudentEntity() {
       Student student = new Student();
       student.setName("John Doe");
       student.setId(2L);
       assertEquals(2l, student.getId());
       assertEquals("John Doe",student.getName());

    }
    @Test
    void testStudentService() {
        Student student = new Student();
        student.setName("John Doe");
        student.setId(2L);
        studentService.saveStudent(student);
        assertEquals("John Doe", studentService.getStudentById(2l).getName());
    }

    @Autowired
    ProfessorService professorService;

    @Test
    void testProfessorEntity(){
        Professor professor = new Professor();
        professor.setId(2L);
        professor.setName("Ilmi");
        assertEquals(2l, professor.getId());
        assertEquals("Ilmi",professor.getName());
    }

    @Test
    void testProfessorService() {
        Professor professor = new Professor();
        professor.setId(2L);
        professor.setName("Ilmi");
        professorService.saveProfessor(professor);
        assertEquals("Ilmi", professorService.getProfessorById(2l).getName());
    }

    @Autowired
    QuestionService questionService;

    @Test
    void testQuestionEntity(){
        Question question = new Question();
        question.setQuestionText("this is a question");
        question.setId(1L);
        question.setCorrectAnswer("10");
        assertEquals(1L, question.getId());
        assertEquals("this is a question",question.getQuestionText());
        assertEquals("10",question.getCorrectAnswer());

    }

    @Test
    void testQuestionService(){
        Question question = new Question();
        question.setQuestionText("this is a question");
        question.setId(11L);
        question.setCorrectAnswer("10");
        questionService.saveQuestion(question);
        assertEquals("this is a question", questionService.getQuestionById(11L).getQuestionText());
        assertEquals("10", questionService.getQuestionById(11L).getCorrectAnswer());

    }

    @Autowired
    AnswerService answerService;
    @Test
    void testAnswerEntity(){
        Answer answer = new Answer();

        Question question = new Question();
        question.setQuestionText("this is a question");
        question.setId(1L);
        question.setCorrectAnswer("10");

        answer.setQuestion(question);
        answer.setCorrectAnswer(question.getCorrectAnswer());

        Student student = new Student();
        student.setName("John Doe");
        student.setId(2L);

        answer.setStudent(student);
        answer.setStudentAnswer("20");
        answer.setId(20L);



        assertEquals(20L, answer.getId());
        assertEquals("this is a question",answer.getQuestion().getQuestionText());
        assertEquals("10",answer.getQuestion().getCorrectAnswer());
        assertEquals("20",answer.getStudentAnswer());
        assertEquals(2L,answer.getStudent().getId());



    }

    @Test
    void testAnswerService(){
        //Testing existing answer in the table
        assertEquals("20",answerService.getAnswerById(26L).getStudentAnswer());
    }

}

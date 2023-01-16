package com.example.Quiz_Project.controller;

import com.example.Quiz_Project.pojo.*;
import com.example.Quiz_Project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //Service wires
    @Autowired
    private StudentService studentService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private LeaderboardService leaderboardService;
    @Autowired
    private QuestionService questionService;

    //Request for creating student, Body of student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    //Request a get for a student by student id
    @GetMapping("/{studentId}")
    public Student findById(@PathVariable long studentId) {
        return studentService.getStudentById(studentId);
    }

    //Request a get for all students
    @GetMapping
    public List<Student> findAll() {
        return studentService.getAllStudents();
    }

    //Request a post for answering a question
    //Requesting two parameters, one for the student answering and one for the question id
    @PostMapping("/answers")
    public Answer createAnswer(@RequestBody Answer answer, @RequestParam long studentId, @RequestParam long questionId) {
        //Get the student by ID
        Student student = studentService.getStudentById(studentId);
        //set the different data
        answer.setStudent(student);
        answer.setQuestion(questionService.getQuestionById(questionId));
        answer.setCorrectAnswer(questionService.getQuestionById(questionId).getCorrectAnswer());
        //Creat answer
        Answer createdAnswer = answerService.createAnswer(answer);
        //Update points, send in student and also if the question answered is correct
        leaderboardService.updatePoints(student,createdAnswer.isCorrect());
        return createdAnswer;
    }


}
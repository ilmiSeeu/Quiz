package com.example.javapro.controller;

import com.example.javapro.pojo.Professor;
import com.example.javapro.pojo.Question;
import com.example.javapro.service.ProfessorService;
import com.example.javapro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    //Wire the services
    @Autowired
    private QuestionService questionService;

    //Need professor because only they can edit questions
    @Autowired
    private ProfessorService professorService;

    //Request a get for all questions
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //Request a get for all questions
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable long id){
        return questionService.getQuestionById(id);
    }

    //Request to post a question, we are first requesting the question body as input, we also request a parameter that will be professor ID
    //The reason for this is that we will check if this ID is of a professor, because only professors can post questions
    @PostMapping
    public Question createQuestion(@RequestBody Question question, @RequestParam long id) throws AccessDeniedException {
        //Check if this professorID is in the database
        Professor professor = professorService.getProfessorById(id);
        //if no professor throw exception
        if(professor == null ) {
            throw new AccessDeniedException("Only professors can create questions");
        }
        //else create question
        return questionService.saveQuestion(question);
    }

    //same logic as over
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable long id, @RequestBody Question question, @RequestParam long professorId) throws AccessDeniedException {
        Professor professor = professorService.getProfessorById(professorId);
        if(professor == null ) {
            throw new AccessDeniedException("Only professors can update questions");
        }
        question.setId(id);
        return questionService.saveQuestion(question);
    }

    //same logic as over
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable long id, @RequestParam long professorId) throws AccessDeniedException {
        Professor professor = professorService.getProfessorById(professorId);
        if(professor == null ) {
            throw new AccessDeniedException("Only professors can delete questions");
        }
        questionService.deleteQuestion(id);
    }

}
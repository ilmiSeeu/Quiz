package com.example.javapro.service;

import com.example.javapro.pojo.Question;
import com.example.javapro.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    //Returns a list of all questions
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    //returns a question by ID
    public Question getQuestionById(long id){
        return questionRepository.findById(id).get();
    }

    //Saves a questionin the database
    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }

    //Deletes a question by ID.
    public void deleteQuestion(long id){
        questionRepository.deleteById(id);
    }
}
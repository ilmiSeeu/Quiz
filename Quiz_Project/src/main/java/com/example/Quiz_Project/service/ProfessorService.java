package com.example.Quiz_Project.service;

import com.example.Quiz_Project.pojo.Professor;
import com.example.Quiz_Project.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    //Returns list of all professors in the database
    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    //Returns a professor by ID
    public  Professor getProfessorById(long id){
        return professorRepository.findById(id).get();
    }

    //Create a Professor
    public Professor saveProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    //Delete a Professor
    public void deleteProfessor(long id){
        professorRepository.deleteById(id);
    }
}
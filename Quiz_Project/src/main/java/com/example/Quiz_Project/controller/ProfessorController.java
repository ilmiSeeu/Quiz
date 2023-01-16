package com.example.Quiz_Project.controller;

import com.example.Quiz_Project.pojo.Professor;
import com.example.Quiz_Project.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    //Request to create a professor
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    //Request to get a professor by ID
    @GetMapping("/{id}")
    public Professor findById(@PathVariable long id) {
        return professorService.getProfessorById(id);
    }

    //Request to get all Professors
    @GetMapping
    public List<Professor> findall() {
        return professorService.getAllProfessors();
    }

    //Delete professor by id
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable long id) {
        professorService.deleteProfessor(id);
    }
}
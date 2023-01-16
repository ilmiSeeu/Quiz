package com.example.javapro.service;

import com.example.javapro.pojo.Student;
import com.example.javapro.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //Return a list of all Students in the Database
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Return a student by id
    public Student getStudentById(long id){
        return studentRepository.findById(id).get();
    }

    //Create a student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    //Delete a student by id
    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }
}
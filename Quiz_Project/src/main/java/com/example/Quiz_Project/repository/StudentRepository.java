package com.example.Quiz_Project.repository;

import com.example.Quiz_Project.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
package com.example.schoolmanagment1.Repository;

import com.example.schoolmanagment1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    Student findStudentByMajor(String major);
    Student findStudentByAgeGreaterThanEqual(Integer age);
}
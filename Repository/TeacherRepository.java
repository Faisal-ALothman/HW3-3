package com.example.schoolmanagment1.Repository;

import com.example.schoolmanagment1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    Teacher findTeacherBySalaryGreaterThanEqual(Integer salary);
}
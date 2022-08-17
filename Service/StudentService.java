package com.example.schoolmanagment1.Service;

import com.example.schoolmanagment1.Exption.Apiexception;

import com.example.schoolmanagment1.Repository.StudentRepository;
import com.example.schoolmanagment1.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
    public void updateStudent(Student student,Integer id){
        Student oldStudent= studentRepository.getById(id);
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public Student FindStudent(Integer id){
        if (studentRepository.findStudentById(id)==null){
            throw  new Apiexception("bad request ");
        }
        return studentRepository.findStudentById(id);
    }
    public Student FindStudentByName(String name){
        if (studentRepository.findStudentByName(name)==null){
            throw  new Apiexception("bad request ");
        }
        return studentRepository.findStudentByName(name);
    }
    public List<Student> FindStudentByMajor(String major){
        if (studentRepository.findStudentByMajor(major)==null){
            throw  new Apiexception("bad request ");
        }
        return (List<Student>) studentRepository.findStudentByMajor(major);
    }
    public List<Student> FindStudentByAge(Integer age){
        if (studentRepository.findStudentByAgeGreaterThanEqual(age)==null){
            throw  new Apiexception("bad request ");
        }
        return (List<Student>) studentRepository.findStudentByAgeGreaterThanEqual(age);
    }
}
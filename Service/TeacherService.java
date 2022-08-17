package com.example.schoolmanagment1.Service;

import com.example.schoolmanagment1.Exption.Apiexception;
import com.example.schoolmanagment1.Repository.StudentRepository;
import com.example.schoolmanagment1.Repository.TeacherRepository;
import com.example.schoolmanagment1.model.Teacher;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void deleteTeacher(Integer id){
        teacherRepository.deleteById(id);
    }
    public void updateTeacher(Teacher teacher, Integer id){
        Teacher oldTeacher= teacherRepository.getById(id);
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public List<Teacher> FindTeacherBySalary(Integer salary){
        if (teacherRepository.findTeacherBySalaryGreaterThanEqual(salary)==null){
            throw  new Apiexception("bad request ");
        }
        return (List<Teacher>) teacherRepository.findTeacherBySalaryGreaterThanEqual(salary);
    }
    public Teacher FindTeacher(Integer id){
        if (teacherRepository.findTeacherById(id)==null){
            throw  new Apiexception("bad request ");
        }
        return teacherRepository.findTeacherById(id);
    }
}
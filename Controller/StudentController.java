package com.example.schoolmanagment1.Controller;

import com.example.schoolmanagment1.Dto.ApiResponse;
import com.example.schoolmanagment1.Service.StudentService;
import com.example.schoolmanagment1.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List> getStudent(){
        List<Student>students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);

    }
    @PostMapping("/register")
    private ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added",200));
    }
    @PutMapping("/update")
    private ResponseEntity updateStudent(@RequestParam @Valid Student student,@RequestBody Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body(new ApiResponse("student updated",200));
    }
    @DeleteMapping("/delete")
    private ResponseEntity deleteStudent(@RequestBody @Valid Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted ",200));
    }
    @GetMapping("/id")
    public ResponseEntity<Student> findStudentById(@RequestBody Integer id){
        Student student=  studentService.FindStudent(id);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/name")
    public ResponseEntity<Student> findStudentByName(String name){
        Student student=  studentService.FindStudentByName(name);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/major")
    public ResponseEntity<List<Student>> findStudentByMajor(@RequestParam String major){
        List student=  studentService.FindStudentByMajor(major);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/age")
    public ResponseEntity<List<Student>> findStudentByAge(@RequestParam Integer age){
        List student=  studentService.FindStudentByAge(age);
        return ResponseEntity.status(200).body(student);

    }
}
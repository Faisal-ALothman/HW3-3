package com.example.schoolmanagment1.Controller;

import com.example.schoolmanagment1.Dto.ApiResponse;

import com.example.schoolmanagment1.Service.StudentService;
import com.example.schoolmanagment1.Service.TeacherService;
import com.example.schoolmanagment1.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<Teacher>teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);

    }
    @PostMapping("/register")
    private ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added",200));
    }
    @PutMapping("/update")
    private ResponseEntity updateTeacher(@RequestParam @Valid Teacher teacher,@RequestBody Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated",200));
    }
    @DeleteMapping("/delete")
    private ResponseEntity deleteTeacher(@RequestBody @Valid Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted ",200));
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Teacher>> findTeacherBySalary(@RequestParam Integer salary){
        List teacher=  teacherService.FindTeacherBySalary(salary);
        return ResponseEntity.status(200).body(teacher);

    }
    @GetMapping("/id")
    public ResponseEntity<Teacher> findTeacherById(@RequestBody Integer id){
        Teacher teacher=  teacherService.FindTeacher(id);
        return ResponseEntity.status(200).body(teacher);

    }
}
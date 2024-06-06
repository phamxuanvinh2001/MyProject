package com.example.student_management.controller;

import com.example.student_management.service.TeachingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teaching_class")
public class Teaching_ClassController {

    @Autowired
    private TeachingClassService teaching_classService;
    @GetMapping
    public ResponseEntity<?> getAllTeaching_Class() {
        return ResponseEntity.ok(teaching_classService.findAll());
    }

//    @GetMapping("/get/student/{idStudent}")
//    public Student getStudentByIdStudent(@PathVariable Integer idStudent) {
//        return studentService.getStudentById(idStudent);
//    }

//    @GetMapping("/teacher/{idClass}")
//    public Teacher getTeacherByIdClass(@PathVariable Integer idClass) {
//        return teaching_classService.getTecherByIdClass(idClass);
//    }
}

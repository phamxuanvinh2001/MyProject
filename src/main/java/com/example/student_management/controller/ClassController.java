package com.example.student_management.controller;

import com.example.student_management.entity.ClassRoom;
import com.example.student_management.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @GetMapping
    public ResponseEntity<?> getAllClasses() {
        return ResponseEntity.ok(classService.findAll());
    }

    @GetMapping("/get/{idClass}")
    public ResponseEntity<?> getClassById(@PathVariable int idClass) {
        List<ClassRoom> lst = new ArrayList<>();
        ClassRoom c = classService.findClassById(idClass);
        lst.add(c);
        return  ResponseEntity.ok(lst);
    }
}

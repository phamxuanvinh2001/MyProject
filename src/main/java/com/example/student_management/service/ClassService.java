package com.example.student_management.service;

import com.example.student_management.entity.ClassRoom;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassRoom> findAll() {
        return classRepository.findAll();}

    public ClassRoom findClassById(int idClass) {
        return classRepository.findById(idClass);
    }
//    public Class getClassById(Integer idClass) {
//        return classRepository.findById(idClass).orElse(null);
//    }
}

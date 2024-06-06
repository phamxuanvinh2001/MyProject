package com.example.student_management.service;

import com.example.student_management.entity.Teacher;
import com.example.student_management.entity.Teaching_Class;
import com.example.student_management.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeachingClassService {
    @Autowired
    private TeachingClassRepository teaching_classRepository;
    @Autowired
    private TeacherService teacherService;

    public List<Teaching_Class> findAll() {
        return teaching_classRepository.findAll();
    }
//    public List<Student> getStudentByClass(int idClass) {
//        List<Student> lstStudent = studentRepository.findAll();
//        List<ClassRoom> lstClass = classService.findAll();
//        List<Student> lstStudentIdClass =   lstStudent.stream().filter(x->x.getId_class() == idClass).collect(Collectors.toList());
////       List<String> lstStudentIdClass =   lstStudent.stream().map(x->x.getStudent_name() + x.getAddress()).collect(Collectors.toList());
//        return lstStudentIdClass;
//    }


    //Tim kiem thong tin giao vien theo idClass
    public List<Teacher> getTecherByIdClass(int idClass) {
        List<Teaching_Class> list = teaching_classRepository.findAll();
        List<Teacher> lstTeacher = teacherService.getAllTeachers();
        List<Teacher> listTeacherClass = lstTeacher.stream().filter(x->x.getId()== idClass).collect(Collectors.toList());
        return listTeacherClass;

    }




}

package com.example.student_management.controller;

import com.example.student_management.common.Response;
import com.example.student_management.entity.Student;
import com.example.student_management.entity.Teacher;
import com.example.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

//    @GetMapping("/get/{id}")
//    public ResponseEntity<Teacher> getTeacherById(@PathVariable int idTeacher){
//        Teacher teacher = teacherService.findTeacherById(idTeacher);
//        if (Objects.isNull(teacher)) {
//            return ResponseEntity.ok(teacher); // Trả về thông tin teacher dùng nếu tìm thấy
//        } else {
//            return ResponseEntity.notFound().build(); // Trả về mã 404 nếu không tìm thấy người dùng
//        }
//    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeachers(@PathVariable int id) {
        List<Teacher> lst = new ArrayList<>();
        Teacher teacher = teacherService.findTeacherById(id);
        lst.add(teacher);
        return ResponseEntity.ok(lst);
    }

    @GetMapping("/put/{id}")
    public ResponseEntity<Teacher> putTeacher(@PathVariable int idTeacher , @RequestBody Teacher newteacher) {
        Teacher updateTeacher = teacherService.updateTeacher(idTeacher, newteacher);
        if (updateTeacher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateTeacher);
    }

    @GetMapping("/get-class/{idClass}")
    @ResponseBody
    public Response getAllTeacherByIdClass(@PathVariable Integer idClass) {
        return Response.success().withData(teacherService.getTeacherByIdClass(idClass));
    }
}

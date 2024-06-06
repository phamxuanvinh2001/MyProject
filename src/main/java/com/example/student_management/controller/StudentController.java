package com.example.student_management.controller;

import com.example.student_management.common.Constants;
import com.example.student_management.common.Response;
import com.example.student_management.dto.StudentDTO;
import com.example.student_management.entity.ClassRoom;
import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {

        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/get/{idstudent}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer idstudent) {
        Student student = studentService.findStudentById(idstudent);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

//    @GetMapping("/get/{idStudent}")
//    public ResponseEntity<?> getStudentById(@PathVariable int idStudent) {
//        List<Student> lst = new ArrayList<>();
//        Student student = studentService.findStudentById(idStudent);
//        lst.add(student);
//        return  ResponseEntity.ok(lst);
//    }

    //tao moi
    @PostMapping
    @ResponseBody
    public Response createStudent(@RequestBody StudentDTO student) {
        return Response.success().withData(studentService.createStudent(student));
    }
//    @PostMapping
//    @ResponseBody
//    public Response createStudent(@RequestBody StudentDTO student) {
//        return Response.success().withData(studentService.createStudent(student));
//    }


    //sua
    @PutMapping("/update-student/{id}")
    public Response updateStudent(@PathVariable Integer id, @RequestBody StudentDTO newstudent) {
        Student student = studentService.findStudentById(id);
        if (student == null) {
//            return ResponseEntity.notFound().build();
            return Response.error(Constants.RESPONSE_TYPE.ERROR);
        }
        return Response.success().withData(studentService.updateStudent(id,newstudent));
    }
    //xoa
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        Student student = studentService.findStudentById(id);
        if (Objects.isNull(student)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
    @GetMapping("/get/class/{idClass}")

   public List<Student> getAllStudentsByClass(@PathVariable Integer idClass) {
        return studentService.getStudentByClass(idClass);
    }
    @GetMapping("/get/student/{idStudent}")
   public Student getStudentByIdStudent(@PathVariable Integer idStudent) {
        return studentService.getStudentById(idStudent);
    }

}

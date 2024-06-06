package com.example.student_management.service;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.entity.ClassRoom;
import com.example.student_management.entity.Student;
import com.example.student_management.entity.Teacher;
import com.example.student_management.repository.ClassRepository;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService  {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassService classService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    //Tim kiem hoc sinh theo id
    public Student findStudentById(int idstudent) {
        return studentRepository.findById(idstudent);
    }

    //them moi
    public Student createStudent(StudentDTO student) {
        // check validate studentDTO => error báo lỗi => nếu pass cho xử lý save
        //hàm validate = true
        if (true){
            // throw loi
        }
        Student entity = new Student();
        entity.setStudentName(student.getName());
        entity.setAge(student.getAge());
        return studentRepository.save(entity);
    }
    //Sửa
    public Student updateStudent(Integer idStudent, Student newstudent) {
        Student oldstudent = studentRepository.findById(idStudent).orElse(null);
        if (oldstudent == null) {
            return null;
        }
        oldstudent.setStudentName(newstudent.getStudentName());
        oldstudent.setAge(newstudent.getAge());
        oldstudent.setAddress(newstudent.getAddress());
        oldstudent.setPhone(newstudent.getPhone());
        oldstudent.setScholarship(newstudent.getScholarship());
        oldstudent.setConduct(newstudent.getConduct());
        return studentRepository.save(oldstudent);
    }
    //xóa
//    public void deleteStudent(Integer idStudent) {
//        studentRepository.deleteById(idStudent);
//    }
    public boolean deleteStudent(Integer idStudent) {
        if(!studentRepository.existsById(idStudent)) {
            return false;
        }
        studentRepository.deleteById(idStudent);
        return true;
    }
    //Tim kiem hoc sinh theo lop
   public List<Student> getStudentByClass(int idClass) {
        List<Student> lstStudent = studentRepository.findAll();
        List<ClassRoom> lstClass = classService.findAll();
       List<Student> lstStudentIdClass =   lstStudent.stream().filter(x->x.getId_class() == idClass).collect(Collectors.toList());
//       List<String> lstStudentIdClass =   lstStudent.stream().map(x->x.getStudent_name() + x.getAddress()).collect(Collectors.toList());
        return lstStudentIdClass;
   }
   public Student getStudentById(int idStudent) {
        List<Student> lstStudent = studentRepository.findAll();
        List<ClassRoom> lstClass = classService.findAll();
        List<Student> lstStudentRes = new ArrayList<>();
       Student student =  lstStudent.stream().filter(x->x.getId() == idStudent).findFirst().orElse(null);
       if (student != null){
        ClassRoom classRoom =  lstClass.stream().filter(x->x.getId() == student.getId_class()).findFirst().orElse(null);
           student.setClassName(classRoom.getClass_name());
       }
//       List<String> lstStudentIdClass =   lstStudent.stream().map(x->x.getStudent_name() + x.getAddress()).collect(Collectors.toList());
        return student;
   }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }



}

package com.example.student_management.service;

import com.example.student_management.entity.Teacher;
import com.example.student_management.entity.Teaching_Class;
import com.example.student_management.repository.TeacherRepository;
import com.example.student_management.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeachingClassRepository teaching_classRepository;
//    @Autowired
//    private TeachingClassService teaching_ClassService;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Integer idteacher, Teacher newteacher) {
        // Tìm người dùng theo ID
        Teacher oldteacher = teacherRepository.findById(idteacher).orElse(null);
        // Kiểm tra xem người dùng có tồn tại không
        if (oldteacher == null) {
            return null; // Nếu không tìm thấy người dùng, trả về null
        }
        // Cập nhật thông tin giáo vien với dữ liệu mới từ đối tượng newteacher
        oldteacher.setTeacher_name(newteacher.getTeacher_name());
        oldteacher.setAge(newteacher.getAge());
        oldteacher.setAddress(newteacher.getAddress());
        oldteacher.setEmail(newteacher.getEmail());
        oldteacher.setPhone(newteacher.getPhone());
        // Lưu thay đổi vào cơ sở dữ liệu và trả về teacher dùng đã được cập nhật
        return teacherRepository.save(oldteacher);
    }


    public Teacher findTeacherById(int idTeacher) {
        return teacherRepository.findById(idTeacher);
    }



//    public List<Teacher> getTeacherByIdClass(int idClass) {
//        List<Teacher> lstTeacher = teacherRepository.findAll();
//        List<Teaching_Class> lstTeaching_class = teaching_ClassService.findAll();
//
//        List<Teaching_Class> listClass = lstTeaching_class.stream().filter(x->x.getIdClass() == idClass).collect(Collectors.toList());
//
//        List<Teacher> lstTeacherRes = lstTeacher.stream().filter(x->x.getId() == listClass.forEach();)
//
////
//    }

    public List<Teacher> getTeacherByIdClass(int idClass){
      List<Teaching_Class> lstTeaching_class = teaching_classRepository.findByIdClass(idClass);
      if (Objects.isNull(lstTeaching_class)){
          System.out.println("Not find");
          return null;
      }
      List<Integer> teacherIds = lstTeaching_class.stream().map(Teaching_Class::getIdTeacher).collect(Collectors.toList());
      return teacherRepository.findAllById(teacherIds);
    }


}

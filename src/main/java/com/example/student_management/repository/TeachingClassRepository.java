package com.example.student_management.repository;

import com.example.student_management.entity.Teaching_Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachingClassRepository extends JpaRepository<Teaching_Class, Integer> {
    List<Teaching_Class> findByIdClass(int idClass);

}

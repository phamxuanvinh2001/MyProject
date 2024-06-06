package com.example.student_management.repository;

import com.example.student_management.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassRoom,Integer> {
    ClassRoom findById(int id);
}


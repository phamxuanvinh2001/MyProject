package com.example.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_student")
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "scholarship")
    private String scholarship;
    @Column(name = "conduct")
    private String conduct;
    @Column(name = "id_class")
    private Integer id_class;
    @Transient
    private String className;
}

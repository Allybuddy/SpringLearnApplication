package com.example.springLearn.SpringStructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "students", schema = "ems")
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "first_name")
    private String name;
}

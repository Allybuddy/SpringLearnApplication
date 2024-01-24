package com.example.springLearn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Student")
public class StudentEntity {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
}

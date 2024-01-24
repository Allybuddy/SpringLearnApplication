package com.example.springLearn.service;

import com.example.springLearn.entity.StudentEntity;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    List<StudentEntity> getData();

    StudentEntity putData(StudentEntity data);
}

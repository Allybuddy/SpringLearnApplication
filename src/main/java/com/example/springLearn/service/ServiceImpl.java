package com.example.springLearn.service;

import com.example.springLearn.entity.StudentEntity;
import com.example.springLearn.repository.StudentRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service{

    private final StudentRepo studentRepo;

    @Override
    public List<StudentEntity> getData() {
        return studentRepo.getData();
    }

    @Override
    public StudentEntity putData(StudentEntity data) {
        return studentRepo.save(data);
    }
}

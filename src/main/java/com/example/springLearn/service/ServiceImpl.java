package com.example.springLearn.service;

import com.example.springLearn.dto.StudentDto;
import com.example.springLearn.entity.StudentEntity;
import com.example.springLearn.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl{

    private final StudentRepo studentRepo;

    public List<StudentDto> getData() {
        List<StudentEntity> resRepo = studentRepo.getData();
        List<StudentDto> res = new ArrayList<>();
        BeanUtils.copyProperties(resRepo,res);
        return res;
    }

    public StudentEntity putData(StudentEntity data) {
        return studentRepo.save(data);
    }

    public List<StudentDto> test() {
        //throw new MyCustomException();
        throw new MyCustomException("exception allvin", HttpStatus.BAD_REQUEST);
    }
}

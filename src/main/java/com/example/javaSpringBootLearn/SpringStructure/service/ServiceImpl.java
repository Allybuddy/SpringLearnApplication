package com.example.javaSpringBootLearn.SpringStructure.service;

import com.example.javaSpringBootLearn.SpringStructure.dto.StudentDto;
import com.example.javaSpringBootLearn.SpringStructure.entity.StudentEntity;
import com.example.javaSpringBootLearn.SpringStructure.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl{

    private final StudentRepo studentRepo;

    public List<StudentDto> getData() {
        List<StudentEntity> resRepo = studentRepo.findAll();
        List<StudentDto> res = resRepo.stream()
                .map(entity -> {
                    StudentDto dto = new StudentDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .toList();
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

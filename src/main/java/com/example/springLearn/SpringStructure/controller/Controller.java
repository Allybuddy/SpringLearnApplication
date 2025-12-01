package com.example.springLearn.SpringStructure.controller;

import com.example.springLearn.SpringStructure.dto.StudentDto;
import com.example.springLearn.SpringStructure.entity.StudentEntity;
import com.example.springLearn.SpringStructure.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class Controller {

    private final ServiceImpl service;

    @GetMapping(value = "/getData")
    public ResponseEntity<List<StudentDto>> getData(){
        List<StudentDto> data = service.getData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/putData")
    public ResponseEntity<StudentEntity> putData(@RequestBody StudentEntity dataInput){
        StudentEntity data = service.putData(dataInput);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<List<StudentDto>> test(){
        List<StudentDto> data = service.test();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

package com.example.springLearn.controller;

import com.example.springLearn.entity.StudentEntity;
import com.example.springLearn.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping(value = "/getData")
    public ResponseEntity<List<StudentEntity>> getData(){
        List<StudentEntity> data = service.getData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/putData")
    public ResponseEntity<StudentEntity> putData(@RequestBody StudentEntity dataInput){
        StudentEntity data = service.putData(dataInput);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

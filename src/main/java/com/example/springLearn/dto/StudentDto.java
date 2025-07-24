package com.example.springLearn.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentDto {

    private int id;
    private int age;
    private String name;
}

package com.example.springLearn.SpringStructure.repository;

import com.example.springLearn.SpringStructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<StudentEntity, String> {

    @Query(value = "select * from ems.student" , nativeQuery = true)
    List<StudentEntity> getData();
}

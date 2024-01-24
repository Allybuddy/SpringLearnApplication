package com.example.springLearn.repository;

import com.example.springLearn.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<StudentEntity, String> {

    @Query(value = "select * from ems.student" , nativeQuery = true)
    List<StudentEntity> getData();
}

package com.example.javaSpringBootLearn.SpringStructure.repository;

import com.example.javaSpringBootLearn.SpringStructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, String> {

    //@Query(value = "select * from ems.students" , nativeQuery = true)
    List<StudentEntity> findAll();
}

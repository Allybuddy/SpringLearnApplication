package com.example.springLearn.SpringStructure.repository;

import com.example.springLearn.SpringStructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, String> {

    //@Query(value = "select * from ems.students" , nativeQuery = true)
    List<StudentEntity> findAll();
}

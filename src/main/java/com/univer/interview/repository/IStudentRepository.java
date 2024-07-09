package com.univer.interview.repository;

import com.univer.interview.model.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentsEntity, Integer> {

}

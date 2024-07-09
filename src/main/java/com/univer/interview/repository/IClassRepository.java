package com.univer.interview.repository;

import com.univer.interview.model.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClassRepository extends JpaRepository<ClassEntity, Long> {

    @Query("SELECT e FROM ClassEntity e WHERE e.course.idCourse = ?1")
    Optional<List<ClassEntity>> findByCourse(String id);

}

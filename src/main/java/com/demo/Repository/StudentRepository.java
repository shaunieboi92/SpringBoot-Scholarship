package com.demo.Repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.Entities.Student;

import org.springframework.data.repository.query.Param;

@Repository
public interface StudentRepository extends JpaRepository<Student, BigDecimal>{
	
	/**
	 * find List by Student Name
	 */
	@Query("SELECT f FROM Student f where LOWER (f.name) = LOWER(:name)")
	Student findByName(@Param("name") String name);
	
	
}

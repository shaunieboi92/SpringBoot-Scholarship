package com.demo.Repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.Model.Student;

import org.springframework.data.repository.query.Param;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	/**
	 * find List by Student Name
	 */
	Student findByName(@Param("name") String name);
	

	
}

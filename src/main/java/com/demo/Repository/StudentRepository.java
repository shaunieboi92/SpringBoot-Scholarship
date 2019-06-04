package com.demo.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.Entities.Student;

import org.springframework.data.repository.query.Param;

@Component
public interface StudentRepository extends JpaRepository<Student, BigDecimal>{
	/**
	 * find by ID
	 */
	@Query("SELECT f FROM Student f where LOWER (f.id) = LOWER(:id)")
	Student findById(@Param("id") BigDecimal id);
	
	/**find by award type etc**/
	
	
}

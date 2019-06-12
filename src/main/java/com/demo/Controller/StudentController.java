package com.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.demo.Constants.SSTAConstants;
import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.Student;
import com.demo.Service.StudentService;

/**
 *
 * Copyright (c) 2019 System : SSTAnew Subsystem: StudentController File:
 * StudentController.java Change History Date Version Author
 * ------------------------------------------------- Jun 6, 2019 v0.1 Shaun
 *
 * Description
 *
 */
@RestController
@RequestMapping(SSTAConstants.MAIN)
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * getStudents
	 * 
	 * @return List
	 */
	@GetMapping(value = SSTAConstants.STUDENT)
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	/**
	 * getStudentByID
	 * 
	 * @param id
	 * @return Student
	 * @throws SSTAControllerException
	 * @throws ResourceNotFoundException
	 * @throws NumberFormatException
	 */
	@GetMapping(value = SSTAConstants.STUDENT + "/{id}")
	public Student getStudentByID(@PathVariable Long id)
			throws SSTAControllerException, TypeMismatchException {
		return studentService.getStudent(id);
	}

	/**
	 * createNewStudent
	 * 
	 * @param student
	 * @return Student
	 * @throws SSTAControllerException
	 */
	@PostMapping(value = SSTAConstants.STUDENT)
	public void createNewStudent(@Valid @RequestBody Student student)
			throws SSTAControllerException {
		studentService.saveStudent(student);
	}

	/**
	 * deleteStudent
	 * 
	 * @param id
	 * @throws SSTAControllerException
	 */
	@DeleteMapping(value = SSTAConstants.STUDENT + "/{id}")
	public void deleteStudent(@PathVariable Long id)
			throws SSTAControllerException,MethodArgumentTypeMismatchException {
		studentService.deleteStudent(id);
	}

	/**
	 * gettingAwardsByStudentName
	 * 
	 * @param studentName
	 * @return list
	 */
	@GetMapping(value = SSTAConstants.AWARD + "/retrieveAwards"
			+ "/{studentName}")
	public List<Award> getAwardsByStudentName(
			@PathVariable String studentName) {
		return studentService.getAwardsFromStudent(studentName);
	}

	/**
	 * Testing
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String hello() {
		return "Hello Testing!";
	}

}

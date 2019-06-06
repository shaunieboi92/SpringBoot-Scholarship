package com.demo.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.SSTAConstants;
import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.Student;
import com.demo.Service.StudentService;

@RestController
@RequestMapping(SSTAConstants.MAIN)
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	/**
	 * getStudents
	 * @return List
	 */
	@GetMapping(value = SSTAConstants.STUDENT)
	public List<Student> getStudents(){
		return studentService.getStudents();				
	}
	
	/**
	 * getStudentByID
	 * @param id
	 * @return Student
	 * @throws SSTAControllerException 
	 * @throws ResourceNotFoundException 
	 * @throws NumberFormatException 
	 */
	@GetMapping(value = SSTAConstants.STUDENT + "/{id}")
	public Student getStudentByID(@PathVariable String id) throws NumberFormatException, SSTAControllerException {
		return studentService.getStudent(Long.parseLong(id));				
	}
	
	/**
	 * createNewStudent
	 * @param student
	 * @return Student
	 * @throws SSTAControllerException 
	 */
	@PostMapping(value = SSTAConstants.STUDENT + "/add")
	public void createNewStudent(@Valid @RequestBody Student student) throws SSTAControllerException {
		studentService.saveStudent(student);
	}
	
	
	
	@PostMapping(value = SSTAConstants.STUDENT + "/delete" + "/{id}")
	public void deletePersion(@Valid @RequestBody String id) throws SSTAControllerException {
		studentService.deleteStudent(Long.parseLong(id));
	}
	
	/**
	  * gettingAwardsByStudentName
	  * @return list
	  */
	 @GetMapping(value = SSTAConstants.AWARD + "/retrieveAwards" + "/{studentName}")
	 public List<Award> getAwardsByStudentName(@PathVariable String studentName) {
		 return studentService.getAwardsFromStudent(studentName);
	 }
	
	 /**
	  * Testing
	  * @return
	  */
	@RequestMapping("/test")
	public String hello() {
		return "Hello Testing!";
	}
	
}

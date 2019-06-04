package com.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.SSTAConstants;
import com.demo.Entities.Student;
import com.demo.Exception.SSTAException;
import com.demo.Repository.StudentRepository;

import java.math.BigDecimal;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(SSTAConstants.MAIN)
public class SSTAController {

	@Autowired
	private StudentRepository studentRepository;

	
//	 @RequestMapping(value = SSTAConstants.MAIN)
//	 public String index() {
//	 return "Greetings from Spring Boot1!";
//	 }
	
//	 @RequestMapping(value = SSTAConstants.AWARD_HOLDER)
//	 public String index1() {
//	 return "Greetings from Spring Boot2!";
//	 }
//	
//	 @RequestMapping(value = SSTAConstants.MAIN + SSTAConstants.AWARD_ID)
//	 public String index2() {
//	 return "Greetings from Spring Boot2!";
//	 }
//	
//	 @RequestMapping(value = SSTAConstants.MAIN + SSTAConstants.AWARD)
//	 public String index3() {
//	 return "Greetings from Spring Boo3!";
//	 }
//	
//	 @RequestMapping(value = SSTAConstants.MAIN + SSTAConstants.AWARD_TYPE)
//	 public String index4() {
//	 return "Greetings from Spring Boot4!";
//	 }
	
	 @PostMapping("/add")
	 public Student createNewStudent(@Valid @RequestBody Student student) {
	 return studentRepository.save(student);
	 }
	
	@GetMapping(value = "/{id}")
	public Student getStudentByID(@PathVariable String id) {

		return Optional 
				.ofNullable(studentRepository.findById(new BigDecimal(id)))
				.orElse(new Student(new BigDecimal("100"), "User1", "SAAA", "+65 12312",
						"user@email.com"));
		// .orElseThrow(IllegalArgumentException::new);
	}

	@RequestMapping("/test")
	public String hello() {
		return "Hello Testing!";
	}

}

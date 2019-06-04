package com.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.SSTAConstants;
import com.demo.Entities.Award;
import com.demo.Entities.Student;
import com.demo.Exception.SSTAException;
import com.demo.Repository.AwardRepository;
import com.demo.Repository.StudentRepository;
import com.demo.Response.SSTAServiceResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(SSTAConstants.MAIN)
public class SSTAController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	AwardRepository awardRepository;

	// @RequestMapping(value = SSTAConstants.MAIN)
	// public String index() {
	// return "Greetings from Spring Boot1!";
	// }

	// @RequestMapping(value = SSTAConstants.AWARD_HOLDER)
	// public String index1() {
	// return "Greetings from Spring Boot2!";
	// }
	//
	@GetMapping(value = "/AWARD" + "/{id}")
	public Award findAwardbyId(@PathVariable String id) {
		return Optional.ofNullable(awardRepository.findById(new BigDecimal(id)))
				.orElse(new Award());
	}

	@GetMapping(value = SSTAConstants.AWARD)
	public List<Award> getListOfAwards() {
		Collection<Award> awdList = Optional
				.ofNullable(awardRepository.findAllEffective(new Date()))
				.orElse(new ArrayList<>());
		return awdList.stream().collect(Collectors.toList());
	}
	//
	// @RequestMapping(value = SSTAConstants.MAIN + SSTAConstants.AWARD_TYPE)
	// public String index4() {
	// return "Greetings from Spring Boot4!";
	// }

	/**
	  * gettingStudentsByAwards
	  */
	 @GetMapping(value = "/AWARD" + "/retrieveAwards" + "/{studentName}")
	 public List<Award> getAwardsByStudentName(@PathVariable String studentName) {
		 
		 return studentRepository.findByName(studentName).getAwards();
	 
	 }

	@PostMapping("/add")
	public Student createNewStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}

	@GetMapping(value = "/{id}")
	// public Student getStudentByID(@PathVariable String id) {
	public Student getStudentByID(@PathVariable String id) {

		return Optional
				.ofNullable(studentRepository.findById(new BigDecimal(id)))
				.orElse(new Student(new BigDecimal("100"), "User1", "SAAA",
						"+65 12312", "user@email.com"));
		// .orElseThrow(IllegalArgumentException::new);
	}

	@RequestMapping("/test")
	public String hello() {
		return "Hello Testing!";
	}

}

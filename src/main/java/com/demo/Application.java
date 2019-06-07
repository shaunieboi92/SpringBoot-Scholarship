package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.Model.Student;
import com.demo.Repository.StudentRepository;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepo;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void run(String... args) throws Exception{
//		Student student = getStudent();
//		studentRepo.save(student);
//	}
//	
//	private Student getStudent() {
//		Student student = new Student();
//		student.setName("Shaun");
//		student.setNric("SSS");
//		student.setEmail("test@gmail.com");
//		return student;
//	}
}

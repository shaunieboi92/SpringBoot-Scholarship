package com.demo.Service;

import java.util.List;


import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.Student;

/**
 * 
 * @author shaun.lee
 *
 */

public interface StudentService {
	
	public List<Student> getStudents();
	
	public void saveStudent(Student student) throws SSTAControllerException;
	
	public Student getStudent(long id) throws SSTAControllerException;
	
	public void deleteStudent(long id) throws SSTAControllerException;
	
	public List <Award> getAwardsFromStudent(String name);
	
}

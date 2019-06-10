package com.demo.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import com.demo.Constants.SSTAErrorConstants;
import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.Student;
import com.demo.Repository.StudentRepository;
import com.demo.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void saveStudent(Student student) throws SSTAControllerException {
		try {
			studentRepository.save(student);
		} catch (UnexpectedRollbackException | PersistenceException e) {
			throw new SSTAControllerException(
					SSTAErrorConstants.A1001.getErrorCode(),
					SSTAErrorConstants.A1001.getErrorMessage(),
					this.getClass().getCanonicalName(), e);
		}

	}

	@Override
	@Transactional
	public Student getStudent(long id) throws SSTAControllerException {
		return studentRepository.findById(id)
				.orElseThrow(() -> new SSTAControllerException(
						SSTAErrorConstants.A1002.getErrorCode(),
						SSTAErrorConstants.A1002.getErrorMessage(),
						this.getClass().getCanonicalName(),
						new ResourceNotFoundException(id)));
	
	}

	@Override
	@Transactional
	public void deleteStudent(long id) throws SSTAControllerException {
		try {
			studentRepository.deleteById(id);
		} catch (JDBCException e) {
			throw new SSTAControllerException(
					SSTAErrorConstants.A1001.getErrorCode(),
					SSTAErrorConstants.A1001.getErrorMessage(),
					this.getClass().getCanonicalName(), e);
		}
	}

	@Override
	public List<Award> getAwardsFromStudent(String name) {
		return Optional
				.ofNullable(studentRepository.findByName(name).getAwards())
				.orElse(new ArrayList<Award>());
	}

}

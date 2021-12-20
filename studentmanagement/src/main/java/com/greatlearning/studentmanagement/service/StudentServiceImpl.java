package com.greatlearning.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.repository.StudentRepository;

@Repository
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> students  = studentRepository.findAll();
		
		return students;
	}

	@Override
	@Transactional
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		Optional <Student> students =  studentRepository.findById(id);
		return students;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

}

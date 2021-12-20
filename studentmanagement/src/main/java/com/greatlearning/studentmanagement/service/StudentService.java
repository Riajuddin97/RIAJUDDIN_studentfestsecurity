package com.greatlearning.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.studentmanagement.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Optional<Student> findById(int id);

	public void save(Student student);

	public void deleteById(int id);
}

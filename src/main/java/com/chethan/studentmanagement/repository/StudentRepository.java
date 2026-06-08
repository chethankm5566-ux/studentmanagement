package com.chethan.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chethan.studentmanagement.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{
	public Student findByEmail(String email);
	public List<Student> findByName(String name);
	

}

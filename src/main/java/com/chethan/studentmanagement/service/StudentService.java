package com.chethan.studentmanagement.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.chethan.studentmanagement.entity.Student;
import com.chethan.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {
	
	private final  StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository=studentRepository;
	}
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	public List<Student> fetchAllStudent()
	{
		 return studentRepository.findAll();
	}
	public Student findByIdStudent(int id)
	{
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
		{
		
			return student.get();
		}
		return null;
		
		
	}
	public String deleteByIdStudent(int id)
	{
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
		{
		   studentRepository.deleteById(id);
		   return "sucessfully deleted";
		}
		return "student not found";
	}
	public String updateByIdStudent(int id,Student student)
	{
		Optional<Student> student1 = studentRepository.findById(id);
		if(student1.isPresent())
		{
			studentRepository.save(student);
			return "updated sucessfully";
		}
		return "student not found";
		
	}

}

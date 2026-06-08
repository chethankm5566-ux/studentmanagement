package com.chethan.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chethan.studentmanagement.entity.Student;
import com.chethan.studentmanagement.exception.StudentNotFoundException;
import com.chethan.studentmanagement.repository.StudentRepository;

import jakarta.validation.Valid;

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
		throw new StudentNotFoundException("Student not found with id"+id);
	
		
		
	}
	public String deleteByIdStudent(int id)
	{
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
		{
		   studentRepository.deleteById(id);
		   return "sucessfully deleted";
		}
		throw new StudentNotFoundException("Student not found with id"+id);
	}
	public String updateByIdStudent(int id,Student student)
	{
		Optional<Student> student1 = studentRepository.findById(id);
		if(student1.isPresent())
		{
			studentRepository.save(student);
			return "updated sucessfully";
		}
		throw new StudentNotFoundException("Student not found with id"+id);
	}
	public Page<Student> getStudent(int page,int size)
	{
		PageRequest pageable = PageRequest.of(page, size);
		return studentRepository.findAll(pageable);
	}
	public List<Student> getStudentsSorted(String field)
	{
		return studentRepository.findAll(Sort.by(field));
	}
	public Student getStudentEmail(String email)
	{
		return studentRepository.findByEmail(email);
	}
	public List<Student> findByName(String name)
	{
		return studentRepository.findByName(name);
	}
	

}

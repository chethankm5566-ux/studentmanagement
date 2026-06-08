package com.chethan.studentmanagement.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chethan.studentmanagement.entity.Student;
import com.chethan.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	@PostMapping
	public Student saveStudent(@Valid @RequestBody Student  student)
	{
		return studentService.saveStudent(student);
	}
	@GetMapping
	public List<Student> fetchAllStudent()
	{
		return studentService.fetchAllStudent();
	}
	@GetMapping("/{id}")
	public Student findByIdStudent(@PathVariable int id)
	{
		return studentService.findByIdStudent(id);
	}
	@DeleteMapping("/{id}")
	public String  deleteByIdStudent(@PathVariable int id)
	{
		return studentService.deleteByIdStudent(id);
	}
	@PutMapping("/{id}")
	public String updateByIdStudent(@PathVariable int id,@RequestBody Student student)
	{
		return studentService.updateByIdStudent(id, student);
	}
	@GetMapping("/pagination")
	public Page<Student> getStudents(@RequestParam int page,@RequestParam int size)
	{
		return studentService.getStudent(page, size);
	}
	@GetMapping("/sort")
	public List<Student> getStudentsSorted(@RequestParam String field)
	{
		return studentService.getStudentsSorted(field);
	}
     @GetMapping("/email/{email}")
	public Student getStudentEmail(@PathVariable String email)
	{
		return studentService.getStudentEmail(email);
	}
     @GetMapping("/name/{name}")
	public List<Student> findByName(@PathVariable String  name)
	{
		return studentService.findByName(name);
		
	}
}

package com.chethan.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chethan.studentmanagement.entity.Student;
import com.chethan.studentmanagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	@PostMapping
	public Student saveStudent(@RequestBody Student  student)
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

}

package com.chethan.studentmanagement.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public String handleStudentNotFoundException(StudentNotFoundException ex)
	{
		return ex.getMessage();
	}

}

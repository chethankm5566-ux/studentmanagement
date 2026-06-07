package com.chethan.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chethan.studentmanagement.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

}

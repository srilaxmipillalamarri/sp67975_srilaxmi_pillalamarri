package com.zensar.controller.service;



import java.util.List;

import com.zensar.controller.entity.Student;
import com.zensar.dto.StudentDto;

public interface StudentService {
	public StudentDto getStudent(int studentId);

	public List<StudentDto> getStudents(int pageNumber, int pageSize);

	public StudentDto insertStudent(StudentDto studentdto);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);

	
	public List<StudentDto> getByStudentName(String studentName);

	public List<StudentDto> getByStudentNameAndStudentAge(String studentName, int age);

	public List<StudentDto> getByStudentNameOrStudentAge(String studentName, int age);

	

	public List<StudentDto> findByStudentNameOrderBy(String studentName);

}
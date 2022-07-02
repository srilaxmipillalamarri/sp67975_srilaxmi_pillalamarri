package com.zensar.controller.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.controller.entity.Student;
import com.zensar.controller.repository.StudentRepository;

import com.zensar.dto.StudentDto;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	public StudentServiceImpl() {

	}

	@Override
	public StudentDto getStudent(int studentId) {
		Student getStudent = studentRepository.findById(studentId).get();
		// StudentDto dto = mapToDto(getStudent);
		return modelMapper.map(getStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudents(int pageNumber, int pageSize) {
		// List<Student> listOfStudents = studentRepository.findAll();
		Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Student> content = findAll.getContent();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		for (Student student : content) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student insertedStudent = studentRepository.save(student);
		// StudentDto maptoDto = mapToDto(insertedStudent);
		// return maptoDto;
		return modelMapper.map(insertedStudent, StudentDto.class);
		

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		//Student updatedStudent = studentRepository.save(student);
		// StudentDto dto = mapToDto(updatedStudent);
		// return dto;
		
		
	studentRepository.save(student);
	return studentDto;
	}

	public List<StudentDto> getByStudentName(String studentName) {
		// return studentRepository.findByStudentName(studentName);
		// return studentRepository.test(studentName);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.test(studentName);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> getByStudentNameAndStudentAge(String studentName, int age) {
//		return studentRepository.findByStudentNameAndStudentAge(studentName,age); 		
//		return studentRepository.test1(studentName, age); 
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.test1(studentName, age);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> getByStudentNameOrStudentAge(String studentName, int age) {
		// TODO Auto-generated method stub
		// return studentRepository.findByStudentNameOrStudentAge(studentName, age);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.findByStudentNameOrStudentAge(studentName, age);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	

	@Override
	public List<StudentDto> findByStudentNameOrderBy(String studentName) {

		// return studentRepository.findByStudentNameOrderByStudentIdDesc(studentName);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.findByStudentNameOrderByStudentIdDesc(studentName);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	

	/*
	 * public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge()); return student; }
	 * 
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentName(student.getStudentName());
	 * dto.setStudentAge(student.getStudentAge()); return dto;
	 * 
	 * }
	 */

}
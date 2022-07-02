package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.controller.entity.Student;
import com.zensar.controller.service.StudentService;
import com.zensar.dto.StudentDto;

@RestController
@RequestMapping(value = "/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {

	}

	// @RequestMapping("/students/{studentId}")
	@GetMapping(value = "/student/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
		// return studentService.getStudent(studentId);
	}

	// @RequestMapping(value = { "/students", "/listOfStudents" }, method =
	// RequestMethod.GET)
	@GetMapping(value = { "/students","listOfstudents"})
	public ResponseEntity<List<StudentDto>> getStudents(
			@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
			@RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize) {
		//return studentService.getStudents();
		return new ResponseEntity<List<StudentDto>>(studentService.getStudents(pageNumber, pageSize), HttpStatus.OK);
		
	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);
		// return studentService.insertStudent(studentDto);
	}

	

	// @RequestMapping(value="/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentId, studentDto);
		return new ResponseEntity<StudentDto>(studentService.updateStudent(studentId, studentDto), HttpStatus.OK);
		
	}
	// @RequestMapping(value = "/students/{studentId}", method =
		// RequestMethod.DELETE)
		@DeleteMapping(value="/students/{studentId}")
		public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
			studentService.deleteStudent(studentId);
			return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
		}

	@GetMapping(value = "/students/name/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		// return studentService.getByStudentName(studentName);
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentName(studentName), HttpStatus.OK);
	}

	@GetMapping(value = "/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> getByStudentNameAndStudentAge(@PathVariable String studentName,
			@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

	@GetMapping(value = "/students/NameOrAge/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> getByStudentNameOrStudentAge(@PathVariable String studentName,
			@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentNameOrStudentAge(studentName, age),
				HttpStatus.OK);
	}

	

	@GetMapping(value = "/students/order/{studentName}")
	public ResponseEntity<List<StudentDto>> findByStudentNameOrderBy(@PathVariable String studentName) {

		return new ResponseEntity<List<StudentDto>>(studentService.findByStudentNameOrderBy(studentName),
				HttpStatus.OK);
	}

}
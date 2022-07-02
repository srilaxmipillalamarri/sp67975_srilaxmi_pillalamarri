package com.zensar.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.controller.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByStudentName(String studentName);

	List<Student> findByStudentNameOrStudentAge(String studentName, int age);

	List<Student> findByStudentNameOrderByStudentIdDesc(String studentName);

	List<Student> findByStudentNameAndStudentAge(String studentName, int age);

	@Query(value = "from Student s where s.studentName=:name")
	List<Student> test(@Param("name") String studentName);

	@Query(value = " from Student s where s.studentName=:name and s.studentAge=:age")

	List<Student> test1(@Param("name") String studentName, @Param("age") int age);

}
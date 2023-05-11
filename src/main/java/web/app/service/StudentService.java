package web.app.service;

import java.util.List;

import web.app.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	Student deleteStudentById(Long id);
}

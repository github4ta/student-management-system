package web.app.controller;

import web.app.entity.Student;
import web.app.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents(Model model, @RequestParam(required = false) Long id) {
        if (id == null || id == 0L) {
            model.addAttribute("students", studentService.getAllStudents());
            return ResponseEntity.ok(model.addAttribute("students", studentService.getAllStudents()));
        } else {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        Student updatedStudent = studentService.updateStudent(existingStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable Long id) {
        Student student = studentService.deleteStudentById(id);
        return ResponseEntity.ok(student);
    }
}

package web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import web.app.entity.Student;
import web.app.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) {
		
		 Student student1 = new Student("James", "Smith", "james_smith@anywhere.school");
		 studentRepository.save(student1);

		 Student student2 = new Student("Helen", "Brown", "helen_brown@anywhere.school");
		 studentRepository.save(student2);

		 Student student3 = new Student("David", "Jackson", "david_jackson@anywhere.school");
		 studentRepository.save(student3);
	}
}

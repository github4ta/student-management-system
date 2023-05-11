package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}

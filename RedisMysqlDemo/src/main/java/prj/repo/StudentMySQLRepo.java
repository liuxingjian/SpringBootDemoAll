package prj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prj.model.Student;

@Repository
public interface StudentMySQLRepo extends JpaRepository<Student, String> {

    public Student findStudentById(String id);
}

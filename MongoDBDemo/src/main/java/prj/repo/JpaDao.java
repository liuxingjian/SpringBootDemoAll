package prj.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import prj.model.Student;
@Repository
public interface JpaDao extends MongoRepository<Student,String> {
    Student findStudentById(String id);
}

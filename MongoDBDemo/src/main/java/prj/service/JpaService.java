package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.model.Student;
import prj.repo.JpaDao;

@Service
public class JpaService {
    @Autowired
    private JpaDao jpaDao;
    public void save(Student student){
        jpaDao.save(student);
    }
    public Student findById(String id){
        return jpaDao.findStudentById(id);
    }
}

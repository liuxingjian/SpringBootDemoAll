package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.model.Student;
import prj.repo.StudentMySQLRepo;
import prj.repo.StudentRedisDao;

import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentMySQLRepo studentMySQLRepo;
    @Autowired
    private StudentRedisDao studentRedisDao;
    public void saveStudent(Student student){
        studentRedisDao.deleteByID(student.getId());
        studentMySQLRepo.save(student);
    }
    public Student findByID(String id){
        Student empStudent=new Student();
        Random random=new Random();
        empStudent.setId("emptyID");
        Student student= studentRedisDao.findByID(id);
        if(student!=null){
            System.out.println("get from redis");
            if(!student.getId().equals("emptyID")){
                return student;
            }else{
                return null;
            }
        }else{
            System.out.println("get from mysql");
            student=studentMySQLRepo.findStudentById(id);
            int randNum=random.nextInt(100);
            if(student!=null){
                studentRedisDao.studentSave(id,24*60*60+randNum,student);
                return student;
            }else{
                studentRedisDao.studentSave(id,24*60*60+randNum,empStudent);
                return student;
            }
        }
    }
    public void deleteByID(String id){
        studentRedisDao.deleteByID(id);
        studentMySQLRepo.deleteById(id);
    }
}


package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Student;
import prj.repo.JpaDao;
import prj.service.JpaService;

@RestController
public class ControllerForJpa {
    @Autowired
    JpaService jpaService;
    @RequestMapping("/saveByJpa")
    public void saveByJpa(){
        Student student=new Student();
        student.setId("123");
        student.setName("123");
        student.setScore("10");
        jpaService.save(student);
    }
    @RequestMapping("/findByJpa/{id}")
    public Student findByJpa(@PathVariable String id){
        return jpaService.findById(id);
    }
}

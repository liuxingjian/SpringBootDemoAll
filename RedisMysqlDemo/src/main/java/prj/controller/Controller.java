package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Student;
import prj.service.StudentService;

@RestController
public class Controller {
    @Autowired
    StudentService service;

    @RequestMapping("saveStudent")
    public void saveStudent(){
        Student student=new Student();
        student.setId("001");
        student.setName("001");
        student.setScore("001");
        service.saveStudent(student);
    }
    @RequestMapping("/findByID/{id}")
    public Student findByID(@PathVariable String id){
        return service.findByID(id);
    }
    @RequestMapping("/deleteByID/{id}")
    public void deleteByID(@PathVariable String id){
        service.deleteByID(id);
    }
}

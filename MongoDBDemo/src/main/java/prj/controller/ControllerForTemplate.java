package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Student;
import prj.service.TemplateService;

@RestController
public class ControllerForTemplate {
    @Autowired
    TemplateService templateService;
    @RequestMapping("/saveByTemplate")
    public void saveByTemplate(){
        Student student=new Student();
        student.setScore("100");
        student.setName("100");
        student.setId("100");
        templateService.save(student);
    }
    @RequestMapping("/findByTemplate/{id}")
    public Student findByTemplate(@PathVariable String id){
        return templateService.findById(id);
    }
    @RequestMapping("/deleteByTemplate/{id}")
    public void deleteByTemplate(@PathVariable String id){
        templateService.deleteById(id);
    }
}

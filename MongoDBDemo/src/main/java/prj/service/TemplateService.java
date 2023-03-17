package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.model.Student;
import prj.repo.TemplateDao;

@Service
public class TemplateService {
    @Autowired
    private TemplateDao templateDao;
    public void save(Student student){
        templateDao.save(student);
    }
    public void deleteById(String id){
        templateDao.deleteById(id);
    }
    public Student findById(String id){
        return templateDao.findById(id);
    }
}

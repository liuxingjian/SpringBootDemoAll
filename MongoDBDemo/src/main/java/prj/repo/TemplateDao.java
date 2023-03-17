package prj.repo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import prj.model.Student;

import javax.annotation.Resource;

@Component
public class TemplateDao {
    @Resource
    private MongoTemplate mongoTemplate;

    public void save(Student student){
        mongoTemplate.save(student);
    }
    public void deleteById(String id){
        mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)),Student.class);
    }
    public Student findById(String id){
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),Student.class);
    }
}

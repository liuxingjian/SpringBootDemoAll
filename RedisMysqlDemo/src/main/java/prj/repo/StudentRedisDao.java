package prj.repo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import prj.model.Student;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentRedisDao {
    @Autowired
    private RedisTemplate<String,String>redisTemplate;
    public void studentSave(String id, int expiretime, Student student){
        Gson gson=new Gson();
        redisTemplate.opsForValue().set(id,gson.toJson(student),expiretime, TimeUnit.SECONDS);
    }
    public Student findByID(String id){
        Gson gson=new Gson();
        Student student=null;
        String studentJson=redisTemplate.opsForValue().get(id);
        if(studentJson!=null && !studentJson.equals("")){
            student=gson.fromJson(studentJson,Student.class);
        }
        return student;
    }
    public void deleteByID(String id){
        redisTemplate.opsForValue().getOperations().delete(id);
    }
}

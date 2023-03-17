package prj.repo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import prj.model.OrderDetail;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepo {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //向Redis缓存里保存数据
    public void save(int id, int expireTime, OrderDetail orderDetail){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(Integer.valueOf(id).toString(), gson.toJson(orderDetail), expireTime, TimeUnit.SECONDS);
    }
    //从Redis缓存里根据id查找数据
    public OrderDetail findByID(int id){
        Gson gson = new Gson();
        OrderDetail orderDetail = null;
        String json = redisTemplate.opsForValue().get(Integer.valueOf(id).toString());
        if(json != null && !json.equals("")){
            orderDetail =  gson.fromJson(json, OrderDetail.class);
        }
        return orderDetail;
    }
    //从Redis里删除指定id的数据
    public void deleteByID(int id){
        redisTemplate.opsForValue().getOperations().delete(Integer.valueOf(id).toString());
    }
}
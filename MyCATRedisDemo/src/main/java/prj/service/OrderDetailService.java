package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.model.OrderDetail;
import prj.repo.OrderDetailRepo;
import prj.repo.RedisRepo;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    RedisRepo redisRepo;

    public void save(OrderDetail orderDetail){
        redisRepo.deleteByID(orderDetail.getId());
        orderDetailRepo.save(orderDetail);
    }

    public OrderDetail findByID(int id){
        OrderDetail orderDetail = redisRepo.findByID(id);
        if(orderDetail != null) {
            System.out.println("Get From Redis");
            return orderDetail;
        }else {
            System.out.println("Get From MySQL");
            orderDetail = orderDetailRepo.findOrderdetailById(id);

            //如果在数据库存在，则加入缓存
            if(orderDetail !=null) {
                redisRepo.save(id, 24 * 60 * 60, orderDetail);
                return orderDetail;
            }
        }

        return orderDetail;
    }

    public void deleteByID(int id){
        redisRepo.deleteByID(id);
        orderDetailRepo.deleteById(id);
    }
}

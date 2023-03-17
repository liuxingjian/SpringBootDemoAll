package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.model.OrderDetail;
import prj.repo.OrderDetailRepo;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    public void saveStudent(OrderDetail orderDetail){
        orderDetailRepo.save(orderDetail);
    }
    public OrderDetail findById(int id){
        return orderDetailRepo.findOrderDetailById(id);
    }
    public void deleteById(int id){
        orderDetailRepo.deleteById(id);
    }
}

package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.OrderDetail;
import prj.service.OrderDetailService;

@RestController
public class Controller {
    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("/save")
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(11);
        orderDetail.setName("MyCAT");
        orderDetailService.save(orderDetail);
    }

    @RequestMapping("/findByID/{id}")
    public OrderDetail findByID(@PathVariable int id){
        return orderDetailService.findByID(id);
    }

    @RequestMapping("/deleteByID/{id}")
    public void deleteByID(@PathVariable int id){
        orderDetailService.deleteByID(id);
    }

}

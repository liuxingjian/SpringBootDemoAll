package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prj.model.OrderDetail;
import prj.service.OrderDetailService;

@Controller
public class controller {
    @Autowired
    private OrderDetailService orderDetailService;
    @RequestMapping("/save")
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setId(10);
        orderDetail.setName("10");
        orderDetailService.saveStudent(orderDetail);
    }
    @RequestMapping("findById/{id}")
    public OrderDetail findById(@PathVariable int id){
        return orderDetailService.findById(id);
    }
    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable int id){
        orderDetailService.deleteById(id);
    }
    @RequestMapping("/test")
    public String test(){
        return "hello word";
    }

}

package prj.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/buy/{id}")
    public void buy(@PathVariable String id){
        //向验证模块发消息验证id
        amqpTemplate.convertAndSend("myExchange","idQueue",id);
        //该请求处理完毕，等验证模块发异步消息来以后继续
    }
}

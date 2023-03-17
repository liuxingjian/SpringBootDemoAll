package prj.controller;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Stock;

@RestController
public class MQSenderController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sendString")
    public void sendString(){
        amqpTemplate.convertAndSend("myExchange","stringQueue","Test String For MQ");
    }

    @RequestMapping("/sendObject")
    public void sendObject(){
        Stock myStock = new Stock();
        myStock.setID(1);
        myStock.setName("TestInMQ");
        myStock.setNum(1);
        myStock.setDescription("SendCorrectly");

        amqpTemplate.convertAndSend("myExchange","objectQueue",myStock);
    }
}
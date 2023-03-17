package prj.service;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prj.model.ResultModel;

@Component
@RabbitListener(queues = "idQueue")
public class CheckRiskService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void checkidFromQueue(String id){

        ResultModel resultModel = new ResultModel();
        resultModel.setId(id);

        if(Integer.valueOf(id) < 100){
            resultModel.setResult("true");
            System.out.println("No Risk for id:" + id);
        }
        else{
            resultModel.setResult("false");
            System.out.println("Exists Risk for id:" + id);
        }
        //通过消息队列返回风控验证结果
        amqpTemplate.convertAndSend("myExchange","resultQueue",resultModel);
    }
}

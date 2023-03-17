package prj.service;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import prj.model.ResultModel;

@Component
@RabbitListener(queues = "resultQueue")
public class HandleValidateService {
    @RabbitHandler
    public void getObjectFromQueue(ResultModel result){
        if(result.getResult().equalsIgnoreCase("true")){
            System.out.println("Validate OK, can continue");
            System.out.println("id is:" + result.getId());
            //进行后继购买动作
        }
        else{
            System.out.println("Validate Fail, cannot continue");
            System.out.println("id is:" + result.getId());
            //抛异常并记录该非法id
        }
    }
}

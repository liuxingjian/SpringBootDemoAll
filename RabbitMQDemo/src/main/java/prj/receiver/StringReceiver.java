package prj.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "stringQueue")
public class StringReceiver {
    @RabbitHandler
    public void getStrFromQueue(String msg){
        System.out.println("Get Msg From stringQueue," + msg);
    }
}

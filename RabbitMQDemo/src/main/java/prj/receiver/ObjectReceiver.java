package prj.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import prj.model.Stock;

@Component
@RabbitListener(queues = "objectQueue")
public class ObjectReceiver {
    @RabbitHandler
    public void getObjectFromQueue(Stock stock){
        System.out.println("Get stock From objectQueue.");
        System.out.println("ID is:" + stock.getID());
        System.out.println("Name is:" + stock.getName());
        System.out.println("Num is:" + stock.getNum());
        System.out.println("Desc is:" + stock.getDescription());
    }
}

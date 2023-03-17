package prj;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig{
    //定义含主题的消息队列
    @Bean
    public Queue idQueue() {
      return new Queue("idQueue");
    }
    @Bean
    public Queue resultQueue() {
        return new Queue("resultQueue");
    }
    //定义交换机
    @Bean
    TopicExchange myExchange() {
        return new TopicExchange("myExchange");
    }
    //根据主题，绑定队列和交换机里
    @Bean
    Binding bindingIDQueue(Queue idQueue,TopicExchange exchange) {
        return BindingBuilder.bind(idQueue).to(exchange).with("idQueue");
    }
    @Bean
    Binding bindingResultQueue(Queue resultQueue,TopicExchange exchange) {
        return BindingBuilder.bind(resultQueue).to(exchange).with("resultQueue");
    }
}


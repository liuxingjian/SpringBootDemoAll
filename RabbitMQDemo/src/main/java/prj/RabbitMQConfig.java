package prj;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig{
    //定义含主题的消息队列
    @Bean
    public Queue stringQueue() {
      return new Queue("stringQueue");
    }
    @Bean
    public Queue objectQueue() {
        return new Queue("objectQueue");
    }
    //定义交换机
    @Bean
    TopicExchange myExchange() {
        return new TopicExchange("myExchange");
    }
    //根据主题，绑定队列和交换机里
    @Bean
    Binding bindingStringQueue(Queue stringQueue,TopicExchange exchange) {
        return BindingBuilder.bind(stringQueue).to(exchange).with("stringQueue");
    }
    @Bean
    Binding bindingObjectQueue(Queue objectQueue,TopicExchange exchange) {
        return BindingBuilder.bind(objectQueue).to(exchange).with("objectQueue");
    }
}


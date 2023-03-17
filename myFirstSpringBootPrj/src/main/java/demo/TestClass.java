package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        //Spring管理Bean的容器
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        Tool tool=(Tool)applicationContext.getBean("tool");
        tool.print();
    }
}

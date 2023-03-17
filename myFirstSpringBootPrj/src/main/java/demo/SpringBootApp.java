package demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class,args);
//关闭定制化启动信息
//        SpringApplication application=new SpringApplication(SpringBootApp.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);
    }
}

package prj.service;
import org.apache.dubbo.config.annotation.Service;

@Service(timeout = 5000,retries = 3)
public class DubboServiceImpl implements  DubboService {
    public String printByDubbo(String msg){
        System.out.println("msg is:" + msg);
        return "In Dubbo Provider, msg is:" + msg;
    }
}

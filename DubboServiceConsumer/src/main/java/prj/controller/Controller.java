package prj.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.service.DubboService;

@RestController
public class Controller {

    @Reference
    DubboService DubboService;

    @RequestMapping("/callDubboProvider/{msg}")
    public String callDubboProvider(@PathVariable String msg){
        return DubboService.printByDubbo(msg);
    }
}

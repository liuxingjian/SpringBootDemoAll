package prj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
;

@RestController
public class Controller {
    @RequestMapping("/aopDemo")
    public String aopDemo(){
        return "C aopDemo";
    }
}

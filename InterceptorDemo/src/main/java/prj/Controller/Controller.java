package prj.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/login/{username}")
    public String login(@PathVariable String username){
        System.out.println("login");
        return "loginOK";
    }
    @RequestMapping("/hackerVisit")
    public String hackerVisit(){
        return "hackerVisitOK";
    }
}

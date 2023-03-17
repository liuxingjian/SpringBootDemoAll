package prj.controller;


import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Mock Service Action";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @GetMapping("/success")
    public ModelAndView success() {
        ModelAndView mv = new ModelAndView("success");
        return mv;
    }

    @PostMapping("/loginAction")
    public ModelAndView doLogin(String username, String password) {

        //获得Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        ModelAndView mv = null;
        try{
            subject.login(token);
            mv = new ModelAndView("success");
        }catch (UnknownAccountException e){
            mv = new ModelAndView("login");
        }
        return mv;
    }

    @GetMapping("/unAuth")       //无权限时候调用
    public ModelAndView unAuth() {
        return new ModelAndView("unAuth");
    }


}

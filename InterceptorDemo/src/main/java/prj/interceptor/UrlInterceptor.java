package prj.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class UrlInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        System.out.println("UrlInterceptor,preHandle");
        String url=request.getRequestURI();
        if(url.toLowerCase().contains("hacker")){
            System.out.println("prevent hacker visit");
            return false;
        }else{
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, @Nullable ModelAndView modelAndView) throws Exception{
        System.out.println("UrlInterceptor,postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handle,@Nullable Exception exception) throws Exception{
        System.out.println("UrlInterceptor,afterCompletion");
    }

}

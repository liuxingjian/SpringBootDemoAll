package prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import prj.interceptor.ParamInterceptor;
import prj.interceptor.UrlInterceptor;
@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    @Autowired
    UrlInterceptor urlInterceptor;
    @Autowired
    ParamInterceptor paramInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(urlInterceptor).addPathPatterns("/**");
        registry.addInterceptor(paramInterceptor).addPathPatterns("/login/*");
    }
}

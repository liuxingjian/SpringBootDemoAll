package prj;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须要引入安全管理组件SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置登录成功后跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/success");
        //设置未授权的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
        //定义/loginAction请求无需访问权限
        filterChainDefinitionMap.put("/loginAction", "anon");
        //定义访问/hello服务时需要reader权限
        filterChainDefinitionMap.put("/hello", "perms[read]");
        //定期其它格式的请求需要身份认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //以Bean的形式引入安全管理组件
    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myShiroRealm());
        return manager;
    }
    //引入重新定义过的Realm组件
    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }
}

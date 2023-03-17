package prj.Service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class MemAopService {
    @Pointcut("execution(* prj.controller.*.*(..))")
    private void checkMem(){}
    @Before("checkMem()")
    private void before(JoinPoint joinPoint){
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(request.getRequestURL().toString());
        System.out.println("B "+joinPoint.getSignature().getName());
    }
    @After("checkMem()")
    private void printMem(){
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024+"M");
    }
    @Around("checkMem()")
    private Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around for aop");
        Object[] args=joinPoint.getArgs();
        Object ret=joinPoint.proceed(args);
        System.out.println("Ar "+ret);
        return ret;
    }
    @AfterReturning(pointcut = "checkMem()",returning = "returnObj")
    private void afterReturning(Object returnObj){
        System.out.println("Af"+returnObj);
    }
    @AfterThrowing(pointcut = "checkMem()",throwing = "e")
    private void afterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println(e.getMessage());
    }
}

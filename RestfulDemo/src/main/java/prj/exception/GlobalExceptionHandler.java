package prj.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import prj.tool.HttpCodeEnum;
import prj.tool.HttpReturn;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ParamExcepion.class)
    public HttpReturn handlerParamException(ParamExcepion excepion){
        return new HttpReturn(HttpCodeEnum.PARAM_ERROR,excepion.getErrorMsg());
    }
    @ExceptionHandler(Exception.class)
    public HttpReturn handlerOtherException(Exception e){
        return  new HttpReturn(HttpCodeEnum.SERVER_ERROR,e.getMessage());
    }
}

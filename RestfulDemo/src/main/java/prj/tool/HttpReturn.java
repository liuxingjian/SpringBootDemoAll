package prj.tool;

import java.io.Serializable;

public class HttpReturn <T> implements Serializable {
    private Integer httpCode;
    private String httpMsg;
    private T data;

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMsg() {
        return httpMsg;
    }

    public void setHttpMsg(String httpMsg) {
        this.httpMsg = httpMsg;
    }

    public T getdata() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
    }

    public HttpReturn(HttpCodeEnum httpCodeEnum,T data) {
        this.httpCode=httpCodeEnum.getHttpCode();
        this.httpMsg=httpCodeEnum.getHttpMsg();
        this.data=data;
    }

    @Override
    public String toString() {
        return "HttpReturn{+" +
                ",httpCode="+httpCode+
                ",httpMsg="+httpMsg+
                ",data="+data+
                "}";
    }
}

package com.example.demo.Exception;

public class DemoRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errorCode;

    public DemoRuntimeException(String errorMsg){
        super(errorMsg);
    }

    public DemoRuntimeException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

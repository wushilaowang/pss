package com.oupu.pss.exception;

/**
 * Classname:PssException
 * Package:com.oupu.pss.exception
 * Description:处理业务异常
 *
 * @Data:2019/12/19 14:27
 * @Author:
 */
public class PssException extends RuntimeException {
    protected String errCode;
    protected String errMessage;

    public PssException() {
        super();
    }

    public PssException(BaseErrorInfoInterface baseErrorInfoInterface) {
        super(baseErrorInfoInterface.getResultCode());
        this.errCode = baseErrorInfoInterface.getResultCode();
        this.errMessage = baseErrorInfoInterface.getResultMessage();
    }

    public PssException(BaseErrorInfoInterface baseErrorInfoInterface, Throwable cause) {
        super(baseErrorInfoInterface.getResultCode(), cause);
        this.errCode = baseErrorInfoInterface.getResultCode();
        this.errMessage = baseErrorInfoInterface.getResultMessage();
    }

    public PssException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public PssException(String errCode,String errMessage) {
        super(errMessage);
        this.errCode=errCode;
        this.errMessage = errMessage;
    }

    public PssException(String errCode,String errMessage,Throwable cause){
        super(errCode,cause);
        this.errCode=errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

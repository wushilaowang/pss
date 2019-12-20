package com.oupu.pss.exception;

/**
 * Classname:CommonEnumException
 * Package:com.oupu.pss.exception
 * Description:
 *
 * @Data:2019/12/19 11:00
 * @Author:
 */
public enum CommonEnumException implements BaseErrorInfoInterface {
    SUCCESS("200","成功"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!");
    //错误码
    private String resultCode;
    //错误描述
    private String resultMessage;

    CommonEnumException(String i, String 成功) {
        this.resultCode=resultCode;
        this.resultMessage=resultMessage;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMessage() {
        return resultMessage;
    }
}

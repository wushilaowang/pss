package com.oupu.pss.vo;

import com.oupu.pss.exception.BaseErrorInfoInterface;
import com.oupu.pss.exception.CommonEnumException;

import java.io.Serializable;

/**
 * Classname:JsonResult
 * Package:com.oupu.pss.vo
 * Description:
 *
 * @Data:2019/12/18 16:30
 * @Author:json返回数据封装
 */
public class JsonResult implements Serializable {
    private String state="0";//默认状态码200成功
    private String message="ok";//返回信息
    private Object data;//返回数据

    public JsonResult() {
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult success(){
        return success();
    }

    public static JsonResult success(Object para){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setState(CommonEnumException.SUCCESS.getResultCode());
        jsonResult.setMessage(CommonEnumException.SUCCESS.getResultMessage());
        jsonResult.setData(para);
        return jsonResult;
    }

    public static JsonResult error(BaseErrorInfoInterface baseErrorInfoInterface){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setState(baseErrorInfoInterface.getResultCode());
        jsonResult.setMessage(baseErrorInfoInterface.getResultMessage());
        return jsonResult;
    }

    public JsonResult(BaseErrorInfoInterface baseErrorInfoInterface){
        this.state=baseErrorInfoInterface.getResultCode();
        this.message=baseErrorInfoInterface.getResultMessage();
    }

    public JsonResult(String message) {
        this.message=message;
    }

    public JsonResult(String state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public JsonResult(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(String state, Object data) {
        this.state = state;
        this.data = data;
    }

    //返回异常
    public JsonResult(Throwable t){
        t.printStackTrace();
        this.message=t.getMessage();
    }
}

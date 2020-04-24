package com.oupu.pss.vo;

import java.io.Serializable;

/**
 * Classname:JsonResult
 * Package:com.oupu.pss.vo
 * Description:
 *
 * @Data:2019/12/18 16:30
 * @Author:json返回数据封装
 */
public class LayUIJson implements Serializable {
    private int code;
    private String message;
    private Object data;//返回数据
    private int count;


    public LayUIJson(int code, String message, int count, Object data){
        this.code=code;
        this.message=message;
        this.count=count;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

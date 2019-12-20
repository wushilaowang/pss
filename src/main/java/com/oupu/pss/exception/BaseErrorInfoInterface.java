package com.oupu.pss.exception;

/**
 * Classname:BaseErrorInfoInterface
 * Package:com.oupu.pss.exception
 * Description:
 *
 * @Data:2019/12/19 10:45
 * @Author:
 */
public interface BaseErrorInfoInterface {
    //错误码
    String getResultCode();
    //错误描述
    String getResultMessage();
}

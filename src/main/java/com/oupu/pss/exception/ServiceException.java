package com.oupu.pss.exception;

/**
 * Classname:ServiceException
 * Package:com.oupu.pss.exception
 * Description:
 *
 * @Data:2019/12/19 10:36
 * @Author:
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}

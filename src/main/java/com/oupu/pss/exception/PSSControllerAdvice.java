package com.oupu.pss.exception;

import com.oupu.pss.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Classname:GlobarException
 * Package:com.oupu.pss.exception
 * Description:
 *
 * @Data:2019/12/18 16:55
 * @Author:
 */
@ControllerAdvice//发生在@RequestMapping的异常都会被捕获
public class PSSControllerAdvice {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e){
        return new JsonResult(e);
    }
}

package com.oupu.pss.exception;

import com.oupu.pss.vo.JsonResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
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
        JsonResult r=new JsonResult();
        r.setState("0");
        if(e instanceof UnknownAccountException) {
            r.setMessage("账户不存在");
        }else if(e instanceof LockedAccountException) {
            r.setMessage("账户已被禁用");
        }else if(e instanceof IncorrectCredentialsException) {
            r.setMessage("密码不正确");
        }else if(e instanceof AuthorizationException) {
            r.setMessage("没有此操作权限");
        }else {
            r.setMessage("系统维护中");
        }

        if(e instanceof UnauthorizedException){
            r.setMessage("权限不足");
        }
        e.printStackTrace();
        return r;
    }
}

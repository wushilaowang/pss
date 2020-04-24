package com.oupu.pss.LogAop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Classname:LogAspect
 * Package:com.oupu.pss.LogAop
 * Description:
 *
 * @Data:2019/12/23 12:04
 * @Author:
 */

@Aspect
@Slf4j
@Service
public class LogAspect {

    @Pointcut("@annotation(com.oupu.pss.LogAop.LogAnnotation)")
    public void logPointcut(){

    }

    @After("logPointcut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH mm ss");
        String formatDate=simpleDateFormat.format(date);
        //获取类目方法名
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的方法对象
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //获得方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获得参数类型
        String[] parameterNames1 = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        //获取方法名
        String name = methodSignature.getName();
        //通过方法名和参数获得定义的方法
        Method targetClassMethod = targetClass.getMethod(name, parameterTypes);
        //获取方法上的注解
        LogAnnotation annotation = targetClassMethod.getAnnotation(LogAnnotation.class);

        //获取参数
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();
        StringBuilder param=new StringBuilder();
        for (int i=0;i<parameterNames.length;i++) {
            param=param.append(parameterNames[i]).append(args[i]);
        }
        log.info("时间"+formatDate+"类名"+declaringTypeName+"方法名"+methodName+"参数"+param+"注解"+annotation.value());
    }


}

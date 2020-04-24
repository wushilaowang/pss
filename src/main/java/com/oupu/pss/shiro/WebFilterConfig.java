package com.oupu.pss.shiro;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * Classname:WebFilterConfig
 * Package:com.oupu.pss.shiro
 * Description:
 *
 * @Data:2019/12/25 16:37
 * @Author:
 */
@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean newFilterRegistrationBean(){
        //过滤器注册器对象
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        //注册过滤器对象
        DelegatingFilterProxy shiroFilterFactory = new DelegatingFilterProxy("shiroFilterFactory");
        filterRegistrationBean.setFilter(shiroFilterFactory);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}

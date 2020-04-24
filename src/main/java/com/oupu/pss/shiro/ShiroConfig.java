package com.oupu.pss.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * Classname:ShiroConfig
 * Package:com.oupu.pss.shiro
 * Description:
 *
 * @Data:2019/12/25 16:21
 * @Author:
 */
@Configuration
public class ShiroConfig {
    //shiro核心管理器对象
    @Bean
    public SecurityManager newSecurityManager(@Autowired ShiroUserRealm shiroUserRealm,
                                              @Autowired CacheManager cacheManager){
        DefaultWebSecurityManager defaultWebSecurityManager
                = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroUserRealm);
        defaultWebSecurityManager.setCacheManager(cacheManager);
        return defaultWebSecurityManager;
    }

    //配置过滤工厂bean对象
    @Bean(value = "shiroFilterFactory")
    public ShiroFilterFactoryBean newShiroFilterFactoryBean
    (@Autowired SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/register");
        //创建map存放拦截
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/js/**","anon");
        map.put("/register","anon");
        map.put("/user/login","anon");
        map.put("/user/queryAccountByAccount","anon");
        map.put("/user/register","anon");
        map.put("/user/queryEmailByEmail","anon");
        map.put("/loginOut","logout");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //管理shirobean的生命周期
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    //DefaultAdvisorAutoProxyCreator是用来扫描上下文，寻找所有的Advistor(通知器）
    // ，将这些Advisor应用到所有符合切入点的Bean中,保证创建DefaultAdvisorAutoProxyCreator
    // 之前先创建LifecycleBeanPostProcessor
    @Bean
    @DependsOn ("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    //配置advisor对象,shiro框架底层会通过此对象的matchs方法返回值决定是否创建代理对象,进行权限控制。
    @Bean
    public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor(
            @Autowired SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //缓存
    @Bean
    public CacheManager shiroCacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    //html可以用shiro标签
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}

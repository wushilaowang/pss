package com.oupu.pss.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classname:QuartzConfig
 * Package:com.oupu.pss.quartz
 * Description:trigger scheduler
 *
 * @Data:2019/12/23 9:11
 * @Author:
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail goodsDetail(){
        JobDetail jobDetail= JobBuilder.newJob(GoodsQuartz.class)
            .withIdentity("GoodsQuartz").storeDurably().build();
        return jobDetail;
    }
    // 一个Job可以对应多个Trigger，但多个Job绑定一个Trigger报错
    @Bean
    public Trigger trigger(){
        CronScheduleBuilder cronScheduleBuilder=
                CronScheduleBuilder.cronSchedule("59 1/1 11 23 12 ? 2099-2099");
        Trigger trigger= TriggerBuilder.newTrigger().
                withSchedule(cronScheduleBuilder).withIdentity("GoodsQuartz").
                forJob(goodsDetail()).build();
        return trigger;
    }
}

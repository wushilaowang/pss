package com.oupu.pss.quartz;

import com.oupu.pss.entity.Goods;
import com.oupu.pss.service.GoodsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Classname:GoodsQuartz
 * Package:com.oupu.pss.quartz
 * Description:定时任务详情操作
 *
 * @Data:2019/12/23 8:54
 * @Author:
 */
public class GoodsQuartz extends QuartzJobBean {
    @Autowired
    private GoodsService goodsService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Goods goods = new Goods();
        goods.setName("quartz");
        goods.setCat(5);
        goods.setDescript("quartz");
        goods.setStock(0);
        goodsService.addGoods(goods);
    }
}

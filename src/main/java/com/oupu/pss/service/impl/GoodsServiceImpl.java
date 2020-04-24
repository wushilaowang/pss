package com.oupu.pss.service.impl;

import com.oupu.pss.LogAop.LogAnnotation;
import com.oupu.pss.dao.DetailMapper;
import com.oupu.pss.entity.Detail;
import com.oupu.pss.entity.Goods;
import com.oupu.pss.dao.GoodsMapper;
import com.oupu.pss.service.GoodsService;
import com.oupu.pss.vo.GoodsVO;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Classname:GoodsServiceImpl
 * Package:com.oupu.pss.service
 * Description:
 *
 * @Data:2019/12/7 17:44
 * @Author:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    DetailMapper detailMapper;

    @Override
    public int queryCountGoods(String query) {
        return goodsMapper.queryCountGoods(query);
    }

    @RequiresPermissions("查询商品")
    @Override
    public List<Goods> findAll(Integer pageNum,Integer pageRecord,String query) {
        int count=goodsMapper.queryCountGoods(query);
        int pageCount=(count-1)/pageRecord+1;//总页数
        pageNum=(pageNum-1)*pageRecord;//页号
        List<Goods> list=goodsMapper.findAll(pageNum,pageRecord,query);
        Logger logger = Logger.getLogger(GoodsServiceImpl.class);
        logger.debug("查询商品");
        logger.info("查询商品");
        return list;
    }

    @LogAnnotation("增加库存")
    @Override
    @Transactional
    public int addStock(int num,int id,String descript,short option) {
        int stock=goodsMapper.queryStock(id);
        Detail detail=new Detail();
        detail.setDescript(descript);
        detail.setNum(num);
        detail.setGoods_id(id);
        detail.setOption(option);
        detail.setResidue(stock+num);
        System.out.println(detail.getResidue());
        detailMapper.addDeatil(detail);
        return goodsMapper.addStock(num,id);
    }

    @LogAnnotation("减少库存")
    @Override
    @Transactional
    public int subtractStock(int num, int id,String descript,short option) {
        int stock=goodsMapper.queryStock(id);
        if(stock<num)
            return -1;
        Detail detail=new Detail();
        detail.setDescript(descript);
        detail.setNum(num);
        detail.setGoods_id(id);
        detail.setOption(option);
        detail.setResidue(stock-num);
        System.out.println(detail.getResidue());
        detailMapper.addDeatil(detail);
        return goodsMapper.subtractStock(num, id);
    }

    @Override
    public List<Goods> queryGoods(String query) {
        return goodsMapper.queryGoods(query);
    }

    @Override
    @Transactional
    public int addGoods(Goods goods) {
        int result=goodsMapper.addGoods(goods);
        int num=goods.getStock();
        int goods_id=goods.getId();
        short option=2;
        Detail detail=new Detail();
        detail.setOption(option);
        detail.setGoods_id(goods_id);
        detail.setNum(num);
        detail.setDescript("添加商品");
        detail.setResidue(num);
        detailMapper.addDeatil(detail);
        return result;
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoods(Integer[] ids) {
        return goodsMapper.deleteGoods(ids);
    }

    @Override
    public GoodsVO findGoodsById(int id) {
        return goodsMapper.findGoodsById(id);
    }
}

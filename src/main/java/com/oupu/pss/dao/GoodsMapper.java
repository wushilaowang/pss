package com.oupu.pss.dao;

import com.oupu.pss.entity.Goods;
import com.oupu.pss.vo.GoodsVO;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface GoodsMapper {
    GoodsVO findGoodsById(int id);
    public int queryCountGoods(String query);
    public int queryStock(int id);
    public List<Goods> findAll(Integer pageNum,Integer pageRecord,String query);
    public int addStock(int num,int id);
    public int subtractStock(int num,int id);
    public List<Goods> queryGoods(String query);
    public int addGoods(Goods goods);
    public int updateGoods(Goods goods);
    public int deleteGoods(Integer[] ids);

    public int findCatByCatId(int id);
}

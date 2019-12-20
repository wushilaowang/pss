package com.oupu.pss.service;

import com.oupu.pss.entity.Goods;
import com.oupu.pss.vo.GoodsVO;

import java.util.List;

/**
 * Classname:GoodsService
 * Package:com.oupu.pss.service
 * Description:
 *
 * @Data:2019/12/7 17:41
 * @Author:
 */
public interface GoodsService {
    public int queryCountGoods(String Goods);
    public List<Goods> findAll(Integer pageNum,Integer pageRecord,String query);
    public int addStock(int num,int id,String descript,short option);
    public int subtractStock(int num,int id,String descript,short option);
    public List<Goods> queryGoods(String query);
    public int addGoods(Goods goods);
    public int updateGoods(Goods goods);
    public int deleteGoods(Integer[] ids);

    GoodsVO findGoodsById(int id);
}

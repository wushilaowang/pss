package com.oupu.pss.dao;

import com.oupu.pss.entity.Detail;
import com.oupu.pss.vo.DetailVO;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface DetailMapper {
    public List<DetailVO> findDetailByGoodsId(Integer goods_id, int pageNum, int pageRecord);
    public int addDeatil(Detail detail);
    public List<Detail> findDetails();
    public int countDetailsByGoodsId(int goods_id);
}

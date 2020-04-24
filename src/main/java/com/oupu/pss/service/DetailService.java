package com.oupu.pss.service;

import com.oupu.pss.entity.Detail;
import com.oupu.pss.vo.DetailVO;

import java.util.List;

/**
 * Classname:DetailService
 * Package:com.oupu.pss.service
 * Description:
 *
 * @Data:2019/12/8 21:32
 * @Author:
 */
public interface DetailService {
    public List<DetailVO> findDetailByGoodsId(Integer goods_id, int pageNum, int pageRecord);
    public int addDetail(Detail detail);
    public List<Detail> findDetails();
    public int countDetailsByGoodsId(Integer goods_id);

}

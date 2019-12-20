package com.oupu.pss.service.impl;

import com.oupu.pss.dao.DetailMapper;
import com.oupu.pss.entity.Detail;
import com.oupu.pss.service.DetailService;
import com.oupu.pss.vo.DetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classname:DetailServiceImpl
 * Package:com.oupu.pss.service.impl
 * Description:
 *
 * @Data:2019/12/8 21:33
 * @Author:
 */
@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;
    @Override
    public List<DetailVO> findDetailByGoodsId(Integer goods_id,int pageNum,int pageRecord) {
        pageNum=(pageNum-1)*pageRecord;
        return detailMapper.findDetailByGoodsId(goods_id,pageNum,pageRecord);
    }

    @Override
    public int addDetail(Detail detail) {
        return detailMapper.addDeatil(detail);
    }

    @Override
    public List<Detail> findDetails() {
        return detailMapper.findDetails();
    }

    @Override
    public int countDetailsByGoodsId(Integer goods_id) {
        return detailMapper.countDetailsByGoodsId(goods_id);
    }


}

package com.oupu.pss.controller;

import com.oupu.pss.entity.Detail;
import com.oupu.pss.service.DetailService;
import com.oupu.pss.vo.DetailVO;
import com.oupu.pss.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Classname:DetailController
 * Package:com.oupu.pss.controller
 * Description:出入库详情
 *
 * @Data:2019/12/8 21:36
 * @Author:
 */
@Controller
public class DetailController {
    @Autowired
    private DetailService detailService;

    @RequestMapping("/detail/findDetailByGoodsId")
    @ResponseBody
    public JsonResult findDetailByGoodsId(@RequestParam Integer goods_id,int pageNum,int pageRecord){
        List<DetailVO> detail=detailService.findDetailByGoodsId(goods_id,pageNum,pageRecord);
        return new JsonResult("200",detail);
    }

    @RequestMapping("/detail/addDetail")
    @ResponseBody
    public JsonResult addDetail(Detail detail){
        int result = detailService.addDetail(detail);
        if(result==0)
            return new JsonResult("出错");
        return new JsonResult("操作成功");
    }

    @RequestMapping("detail/findDetails")
    @ResponseBody
    public JsonResult findDetails(){
        return new JsonResult("200",detailService.findDetails());
    }

    //计算某条商品操作记录数
    @RequestMapping("/detail/countDetailsByGoodsId")
    @ResponseBody
    public JsonResult countDetailsByGoodsId(Integer goods_id){
        return new JsonResult("200",detailService.countDetailsByGoodsId(goods_id));
    }

}

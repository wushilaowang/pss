package com.oupu.pss.controller;

import com.oupu.pss.entity.Goods;
import com.oupu.pss.service.GoodsService;
import com.oupu.pss.vo.GoodsVO;
import com.oupu.pss.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Classname:GoodsControlller
 * Package:com.oupu.pss.controller
 * Description:商品增删改查
 *
 * @Data:2019/12/7 17:23
 * @Author:
 */

@Controller
public class GoodsControlller {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/index")
    public String index(){
        return "index2";
    }

    @RequestMapping("/goods/page")
    public String goodsPage(){
        return "goodspage";
    }

    @RequestMapping("/goods/findGoodsById")
    @ResponseBody
    public JsonResult findGoodsById(int id){
        GoodsVO goodsVO=goodsService.findGoodsById(id);
        return new JsonResult("200",goodsVO);
    }

    @RequestMapping("/goods/findAll")
    @ResponseBody
    public JsonResult findAll(Integer pageNum,Integer pageRecord,String query){
        List<Goods> goodsVO=goodsService.findAll(pageNum,pageRecord,query);
        return new JsonResult("200",goodsVO);
    }

    @RequestMapping("/goods/queryCountGoods")
    @ResponseBody
    public JsonResult queryCountGoods(String query){
        int count=goodsService.queryCountGoods(query);
        return new JsonResult("200",count);
    }


    @RequestMapping("/goods/queryGoods")
    @ResponseBody
    public JsonResult queryGoods(String query){
        List<Goods> list=goodsService.queryGoods(query);
        return new JsonResult("200",list);
    }

    @RequestMapping("/goods/addGoods")
    @ResponseBody
    public JsonResult addGoods(Goods goods){
        int result=goodsService.addGoods(goods);
        if(result==0)
            return new JsonResult("添加失败");
        return new JsonResult("200","添加成功");
    }

    @RequestMapping("/goods/updateGoods")
    @ResponseBody
    public JsonResult updateGoods(Goods goods){
        int result=goodsService.updateGoods(goods);
        System.out.println(result);
        if(result==0)
            return new JsonResult("商品更新失败");
        return new JsonResult("200","商品更新成功");
    }

    @RequestMapping("/goods/addStock")
    @ResponseBody
    public JsonResult addStock(int num,int id,String descript,short option){
        int result=goodsService.addStock(num,id,descript,option);
        if(result==0) {
            return new JsonResult("增加库存失败");
        }
        return new JsonResult("200","增加库存"+num+"个");
    }

    @RequestMapping("/goods/substractStock")
    @ResponseBody
    public JsonResult substractStock(int num,int id,String descript,short option){
        int result=goodsService.subtractStock(num,id,descript,option);
        if(result==0) {
            return new JsonResult( "减少库存失败");
        }else if(result==-1){
            return new JsonResult("200","库存不足");
        }
        return new JsonResult("200","减少库存"+num+"个");
    }

    @RequestMapping("/goods/deleteGoods")
    @ResponseBody
    public JsonResult deleteGoods(Integer[] ids){
        int result=goodsService.deleteGoods(ids);
        if(result>0)
            return  new JsonResult("200","成功删除"+result+"条商品");
        return  new JsonResult("删除商品失败");
    }
}

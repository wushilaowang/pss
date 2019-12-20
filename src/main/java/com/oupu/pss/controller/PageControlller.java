package com.oupu.pss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class PageControlller {

    //数量增加减少页
    @RequestMapping("/detail/substractpage")
    public String substractpage(){
        return "substractpage";
    }
    @RequestMapping("/detail/addpage")
    public String addpage(){
        return "addpage";
    }

    //详情页
    @RequestMapping("/detail/detailpage")
    public String detailpage(){
        return "detailpage";
    }

    //类目页
    @RequestMapping("/goods/catpage")
    public String catpage(){
        return "catpage";
    }

    //类目编辑添加
    @RequestMapping("/goods/addcatpage")
    public String addcatpage(){
        return "addcatpage";
    }

    //商品增加编辑页
    @RequestMapping("/goods/addgoodspage")
    public String addgoodspage(){
        return "addgoodspage";
    }

    @RequestMapping("/goods/editgoodspage")
    public String editgoodspage(){
        return "editgoodspage";
    }


    //类目选择页面
    @RequestMapping("/goods/catchoosepage")
    public String catchoosepage(){
        return "catchoosepage";
    }
}

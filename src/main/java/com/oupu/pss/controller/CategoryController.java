package com.oupu.pss.controller;

import com.oupu.pss.dao.CategoryMapper;
import com.oupu.pss.entity.Category;
import com.oupu.pss.entity.Navigation;
import com.oupu.pss.service.CategoryService;
import com.oupu.pss.service.NavigationService;
import com.oupu.pss.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Classname:NavigetionController
 * Package:com.oupu.pss.controller
 * Description:
 *
 * @Data:2019/12/8 10:16
 * @Author:
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    //添加编辑删除节点
    @RequestMapping("/Category/addCat")
    public JsonResult addCat(Category category) {
        int result = categoryService.addCat(category);
        if (result == 1) {
            return new JsonResult("200","添加类目成功");
        }
        return new JsonResult("类目添加失败");
    }

    @RequestMapping("/Category/editCat")
    public JsonResult editCat(Category category) {
        int result = categoryService.updateCat(category);
        if (result == 1) {
            return new JsonResult("200","类目修改成功");
        }
        return new JsonResult("类目修改失败");
    }

    @RequestMapping("/Category/deleteCat")
    public JsonResult deleteCat(int id) {
        String result = categoryService.deleteCat(id);
        return new JsonResult(result);
    }

    //获取所有节点数据
    @RequestMapping("/Category/findAllCat")
    public JsonResult findParent() {
        return new JsonResult("200",categoryService.findAllCat());
    }

}

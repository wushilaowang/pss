package com.oupu.pss.controller;

import com.oupu.pss.entity.Menu;
import com.oupu.pss.service.MenuService;
import com.oupu.pss.vo.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MenuContorller {
    @Autowired
    private MenuService menuService;

    //根据角色id查询菜单
    @RequestMapping("/menu/findMenuByRoleId")
    @ResponseBody
    public JsonResult findMenuByRoleId(int roleId){
        List<Map<String, Object>> list = menuService.findMenuByRoleId(roleId);
        return new JsonResult("200",list);
    }

    //菜单分配页
    @RequestMapping("/role/menuDistribute")
    public String menuDistribute(){
        return "menudistribute";
    }

    //角色页
    @RequestMapping("/role/menupage")
    public String menuPage(){
        return "menupage";
    }

    //查询所有菜单
    @RequestMapping("/menu/findAllMenu")
    @ResponseBody
    public JsonResult findAllMenu(){
        List<Map<String, Object>> list = menuService.findAllMenu();
        return new JsonResult("200",list);
    }

    //根据角色更新菜单
    @RequestMapping("/role/updateMenuByRoleId")
    @ResponseBody
    public JsonResult updateMenuByRoleId(int roleId,int[] menuIds){
        int result = menuService.updateMenuByRoleId(roleId,menuIds);
        if(result >= 0){
            return new JsonResult("200","更改菜单成功");
        }
        return new JsonResult("0", "更改菜单失败");
    }

    //增加菜单页
    @RequestMapping("/menu/addMenuPage")
    public String addMenupage(){
        return "addmenupage";
    }

    //增删改菜单
    @RequestMapping("/menu/addMenu")
    @ResponseBody
    public JsonResult addMenu(Menu menu){
        int result = menuService.addMenu(menu);
        return new JsonResult("200", "添加菜单成功");
    }

    @RequestMapping("/menu/editMenu")
    @ResponseBody
    public JsonResult editMenu(Menu menu){
        int result = menuService.editMenu(menu);
        return new JsonResult("200", "编辑菜单成功");
    }

    @RequestMapping("/menu/deleteMenu")
    @ResponseBody
    public JsonResult deleteMenu(int id){
        int result = menuService.deleteMenu(id);
        return new JsonResult("200", "删除菜单成功");
    }

    @RequestMapping("/menu/findMenuById")
    @ResponseBody
    public JsonResult findMenuById(int id){
        Menu menu = menuService.findMenuById(id);
        return new JsonResult("200", menu);
    }

    @RequestMapping("/menu/findMenuToolbar")
    @ResponseBody
    public JsonResult findMenuToolbar(){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        List<Menu> list = menuService.findMenuToolbar(userId);
        return new JsonResult("200", list);
    }

    @RequestMapping("/menu/buttonPermission")
    @ResponseBody
    public JsonResult buttonPermission(){
        Set<String> list = (Set<String>)SecurityUtils.getSubject().getSession().getAttribute("permission");
        return new JsonResult("200", list);
    }
}

package com.oupu.pss.controller;

import com.oupu.pss.dao.UserRoleMapper;
import com.oupu.pss.entity.Role;
import com.oupu.pss.service.RoleService;
import com.oupu.pss.vo.JsonResult;
import com.oupu.pss.vo.LayUIJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Classname:RoleController
 * Package:com.oupu.pss.controller
 * Description:
 *
 * @Data:2019/12/27 17:47
 * @Author:
 */
@Slf4j
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleMapper userRoleMapper;

    //找到所有角色带分页
    @RequestMapping("/role/findAllRole")
    @ResponseBody
    public LayUIJson findAllRole(String query, int pageNum, int pageRecord) {
        List<Role> list = roleService.findAllRole(query, pageNum, pageRecord);
        return new LayUIJson(0, "角色列表", 10, list);
    }

    //找到所以角色不带条件
    @RequestMapping("/role/findRoleWithoutConditon")
    @ResponseBody
    public JsonResult findRoleWithoutConditon() {
        List<Role> list = roleService.findRoleWithoutConditon();
        log.info(list.toString());
        return new JsonResult("200", list);
    }

    //分配角色页
    @RequestMapping("/user/roleDistribute")
    public String roleDistribute() {
        return "roleDistribute";
    }

    //根据用户id查询角色
    @RequestMapping("/role/findRoleByUserId")
    @ResponseBody
    public JsonResult findRoleByUserId(int userId) {
        Integer[] roleIds = userRoleMapper.findRoleByUserId(userId);
        return new JsonResult("200", roleIds);
    }

    //更改用户角色
    @RequestMapping("/role/updateUserRole")
    @ResponseBody
    public JsonResult updateUserRole(int userId, int[] roleIds) {
        int result = roleService.updateUserRole(userId,roleIds);
        return new JsonResult("200","更改角色成功");
    }
}

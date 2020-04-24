package com.oupu.pss.controller;

import com.oupu.pss.dao.UserMapper;
import com.oupu.pss.dao.UserRoleMapper;
import com.oupu.pss.entity.User;
import com.oupu.pss.service.UserService;
import com.oupu.pss.vo.JsonResult;
import com.oupu.pss.vo.LayUIJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Classname:UserController
 * Package:com.oupu.pss.controller
 * Description:用户
 *
 * @Data:2019/12/25 10:42
 * @Author:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    //查询所有用户
    @RequestMapping("/user/findAllUser")
    @ResponseBody
    public LayUIJson findAllUser(String query,int pageNum,int pageRecord){
        List<User> list=userService.findAllUser(query,pageNum,pageRecord);
        LayUIJson layUIJson = new LayUIJson(0, "用户数据", 10, list);
        return layUIJson;
    }

    //查询有无账号
    @RequestMapping("/user/queryAccountByAccount")
    @ResponseBody
    public JsonResult queryAccountByAccount(String account){
        int result = userService.queryAccountByAccount(account);
        if(result==1)
            return new JsonResult("201","用户名已存在");
        if(result==0)
            return new JsonResult("200","用户名可用");
        return new JsonResult("0","内部错误");
    }

    //查询有无email
    @RequestMapping("/user/queryEmailByEmail")
    @ResponseBody
    public JsonResult queryEmailByEmail(String email){
        int result = userMapper.queryEmailByEmail(email);
        if(result==1)
            return new JsonResult("201","邮箱已存在");
        if(result==0)
            return new JsonResult("200","邮箱可用");
        return new JsonResult("0","内部错误");
    }

    //用户登陆
    @RequestMapping("/user/login")
    @ResponseBody
    public JsonResult login(String account,String password){
        //获取sbuject对象
        Subject subject = SecurityUtils.getSubject();
        //将账号密码存入token
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(account, password);
        //对用户信息进行认证
        subject.login(usernamePasswordToken);
        return new JsonResult("200","登录成功");
    }

    //用户注册
    @RequestMapping("/user/register")
    @ResponseBody
    public JsonResult register(User user){
        if(userService.addUser(user)==1){
            return new JsonResult("200","注册成功");
        }
        return new JsonResult("0","注册失败");
    }

    //启用禁用
    @RequestMapping("/user/updateValid")
    @ResponseBody
    public JsonResult updateValid(int id,short valid){
        System.out.println(userService.updateValid(id,valid));
        if(userService.updateValid(id,valid)==1){
            return new JsonResult("200","更改成功");
        }
        return new JsonResult("0","更改失败");
    }


}

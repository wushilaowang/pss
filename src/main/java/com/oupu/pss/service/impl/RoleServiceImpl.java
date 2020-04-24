package com.oupu.pss.service.impl;


import com.oupu.pss.dao.RoleMapper;
import com.oupu.pss.dao.UserRoleMapper;
import com.oupu.pss.entity.Role;
import com.oupu.pss.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classname:NavigetionServiceImpl
 * Package:com.oupu.pss.service.impl
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    //@RequiresPermissions("角色管理")
    @Override
    public List<Role> findAllRole(String query, int pageNum, int pageRecord) {
        pageNum = (pageNum - 1) * pageRecord;
        return roleMapper.findAllRole(query, pageNum, pageRecord);
    }

    @Override
    public List<Role> findRoleWithoutConditon() {
        return roleMapper.findRoleWithoutConditon();
    }


    @Override
    public int updateUserRole(@Param("userId") int userId, @Param("roleId") int[] roleIds) {
        int result=userRoleMapper.deleteRoleByUserId(userId);
        if (roleIds != null) {
            for (int roleId : roleIds) {
                userRoleMapper.updateRoleByUserId(userId,roleId);
            }
        }

        return result;
    }
}

package com.oupu.pss.service;

import com.oupu.pss.entity.Role;

import java.util.List;

/**
 * Classname:NavigetionService
 * Package:com.oupu.pss.service
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
public interface RoleService {
    public List<Role> findAllRole(String query, int pageNum, int pageRecord);
    public List<Role> findRoleWithoutConditon();
    public int updateUserRole(int userId, int[] roleIds);
}

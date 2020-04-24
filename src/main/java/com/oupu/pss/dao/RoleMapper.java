package com.oupu.pss.dao;

import com.oupu.pss.entity.Role;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface RoleMapper {

   public List<Role> findAllRole(String query, int pageNum, int pageRecord);
   public List<Role> findRoleWithoutConditon();
   public int updateUserRole(int userId, int[] roleIds);
}

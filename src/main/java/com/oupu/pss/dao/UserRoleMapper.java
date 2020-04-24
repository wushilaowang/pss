package com.oupu.pss.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    public Integer[] findRoleByUserId(int userId);
    public int deleteRoleByUserId(int userId);
    public int updateRoleByUserId(int userId, int roleId);
}

package com.oupu.pss.dao;

import java.util.List;

public interface RoleMenuMapper {
    public Integer[] findMenuByRoleId(int roleId);
    public int deleteMenuByRoleId(int roleId);
    public int updateMenuByRoleId(int roleId, int menuId);
}

package com.oupu.pss.service;

import com.oupu.pss.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Classname:NavigetionService
 * Package:com.oupu.pss.service
 * Description:菜单管理
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
public interface MenuService {
    public List<Map<String, Object>> findMenuByRoleId(int roleId);
    public int updateMenuByRoleId(int roleId, int[] menuIds);
    public List<Map<String, Object>> findAllMenu();
    //增改删菜单
    public int addMenu(Menu menu);
    public int editMenu(Menu menu);
    public int deleteMenu(int id);
    //根据id查找菜单
    public Menu findMenuById(int id);
    //导航栏
    public List<Menu> findMenuToolbar(Integer userId);
}

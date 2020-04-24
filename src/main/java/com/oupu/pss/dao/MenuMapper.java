package com.oupu.pss.dao;


import com.oupu.pss.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface MenuMapper {
    public List<Menu> findAllMenu();
    //子菜单数增减
    public int addChildSize(int parent_id);
    public int substractChildSize(int parent_id);
    //增改删菜单
    public int addMenu(Menu menu);
    public int editMenu(Menu menu);
    public int deleteMenu(int id);
    //获取parent_id
    public int[] getParentIdById(Integer id);
    //获取权限
    public List<String> getPermission(@Param("menuIds") Integer[] menuIds);
    //根据id查找菜单
    public Menu findMenuById(int id);
    //导航栏
    public List<Menu> findMenuToolbar(Integer[] menuIds);

}

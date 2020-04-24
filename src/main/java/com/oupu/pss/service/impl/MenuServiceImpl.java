package com.oupu.pss.service.impl;

import com.oupu.pss.dao.MenuMapper;
import com.oupu.pss.dao.RoleMenuMapper;
import com.oupu.pss.dao.UserMapper;
import com.oupu.pss.dao.UserRoleMapper;
import com.oupu.pss.entity.Menu;
import com.oupu.pss.service.MenuService;
import com.oupu.pss.shiro.ShiroUserRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Map<String, Object>> findAllMenu() {
        List<Menu> list = menuMapper.findAllMenu();
        //存放角色树容器
        List<Map<String, Object>> menuTree = new ArrayList<>();
        //遍历找出一级目录
        Iterator<Menu> menuIterator = list.iterator();
        while(menuIterator.hasNext()){
            Map roleMap = new HashMap();
            Menu menu = menuIterator.next();
            if(menu.getParent_id()==0){
                roleMap.put("id",menu.getId());//id
                roleMap.put("title", menu.getMenu_name());//title
                if(menu.getChild_size() > 0){
                    List<Map<String,Object>> childList = getChild(list,menu.getId());
                    roleMap.put("children", childList);
                }
                menuTree.add(roleMap);
            }
        }
        return menuTree;
    }

    @Override
    @Transactional
    public int addMenu(Menu menu) {
        menu.setChild_size(0);
        if(menu.getParent_id() != 0){
            menuMapper.addChildSize(menu.getParent_id());
        }
        int result = menuMapper.addMenu(menu);
        return result;
    }

    @Override
    public int editMenu(Menu menu) {
        int result = menuMapper.editMenu(menu);
        return result;
    }

    @Transactional
    @Override
    public int deleteMenu(int id) {
        //获取父级id
        int[] parentIds = menuMapper.getParentIdById(id);
        for (int parent_id : parentIds) {
            //存在父级id,减少父级的子数量
            menuMapper.substractChildSize(parent_id);
        }
        //删除id
        int result = menuMapper.deleteMenu(id);
        return result;
    }

    @Override
    public Menu findMenuById(int id) {
        Menu menu = menuMapper.findMenuById(id);
        return menu;
    }

    @RequiresPermissions("导航栏列表")
    @Override
    public List<Menu> findMenuToolbar(Integer userId) {
        //获取角色id
        Integer[] roleIds = userRoleMapper.findRoleByUserId(userId);
        //获取菜单id
        List<Integer> list = new ArrayList<>();
        for (int roleId: roleIds) {
            Integer[] menuByRoleId = roleMenuMapper.findMenuByRoleId(roleId);
            for (int menuId: menuByRoleId) {
                list.add(menuId);
            }
        }
        Integer[] menuIds = {list.size()};
        menuIds = (Integer[])list.toArray(menuIds);
        System.out.println(Arrays.toString(menuIds));
        //获取导航栏集合
        List<Menu> menuList = menuMapper.findMenuToolbar(menuIds);
        return menuList;
    }


    @Override
    public List<Map<String, Object>> findMenuByRoleId(int roleId) {
        List<Menu> list = menuMapper.findAllMenu();
        //存放角色树容器
        List<Map<String, Object>> menuTree = new ArrayList<>();
        //遍历找出一级目录
        Iterator<Menu> menuIterator = list.iterator();
        while(menuIterator.hasNext()){
            Map roleMap = new HashMap();
            Menu menu = menuIterator.next();
            if(menu.getParent_id()==0){
                roleMap.put("id",menu.getId());//id
                roleMap.put("title", menu.getMenu_name());//title
                if(menu.getChild_size() > 0){
                    List<Map<String,Object>> childList = getChild(list,menu.getId(),roleId);
                    roleMap.put("children", childList);
                }else{
                    Integer[] menueIds = roleMenuMapper.findMenuByRoleId(roleId);
                    for (int menuId: menueIds) {
                        if(menuId == menu.getId()) {
                            roleMap.put("checked", true);
                            break;
                        }
                    }
                }
                menuTree.add(roleMap);
            }
        }
        return menuTree;
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShiroUserRealm shiroUserRealm;
    @Override
    @Transactional
    public int updateMenuByRoleId(int roleId, int[] menuIds) {
        int result = roleMenuMapper.deleteMenuByRoleId(roleId);
        if(menuIds != null){
            for (int menuId: menuIds) {
                roleMenuMapper.updateMenuByRoleId(roleId,menuId);
            }
        }
        RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
        ShiroUserRealm realm = (ShiroUserRealm) rsm.getRealms().iterator().next();
        realm.clearAuthz();
        return result;
    }


    //递归子节点
    private List<Map<String, Object>> getChild(List<Menu> list, Integer id, int roleId) {
        Iterator<Menu> iterator = list.iterator();
        List<Map<String,Object>> childList = new ArrayList<>();
        while(iterator.hasNext()){
            Map<String, Object> childMap = new HashMap<>();
            Menu menu = iterator.next();
            if(menu.getParent_id() == id){
                childMap.put("id", menu.getId());
                childMap.put("title", menu.getMenu_name());
                if(menu.getChild_size() > 0){
                    childMap.put("children",getChild(list,menu.getId(),roleId));
                }else{
                    Integer[] menueIds = roleMenuMapper.findMenuByRoleId(roleId);
                    for (int menuId: menueIds) {
                        if(menuId == menu.getId()){
                            childMap.put("checked",true);
                            break;
                        }
                    }
                }
                childList.add(childMap);
            }
        }
        return childList;
    }

    //无勾选递归子节点
    private List<Map<String, Object>> getChild(List<Menu> list, Integer id) {
        Iterator<Menu> iterator = list.iterator();
        List<Map<String,Object>> childList = new ArrayList<>();
        while(iterator.hasNext()){
            Map<String, Object> childMap = new HashMap<>();
            Menu menu = iterator.next();
            if(menu.getParent_id() == id){
                childMap.put("id", menu.getId());
                childMap.put("title", menu.getMenu_name());
                if(menu.getChild_size() > 0){
                    childMap.put("children",getChild(list,menu.getId()));
                }
                childList.add(childMap);
            }
        }
        return childList;
    }
}

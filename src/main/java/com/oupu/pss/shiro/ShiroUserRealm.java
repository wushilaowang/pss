package com.oupu.pss.shiro;

import com.oupu.pss.dao.MenuMapper;
import com.oupu.pss.dao.RoleMenuMapper;
import com.oupu.pss.dao.UserMapper;
import com.oupu.pss.dao.UserRoleMapper;
import com.oupu.pss.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;


import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classname:ShiroUserRealm
 * Package:com.oupu.pss.shiro
 * Description:
 *
 * @Data:2019/12/26 9:20
 * @Author:
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;


    //设置凭证匹配器
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //构建凭证匹配器对象
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-224");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(1);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    //获取用户信息给securityManager
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证器令牌中获取用户名
        UsernamePasswordToken usernamePasswordToken=
                (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        SecurityUtils.getSubject().getSession().setAttribute("userName", username);
        //通过用户名查找用户信息
        User user = userMapper.selectUserByAccount(username);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(user.getValid()==0){
            throw new LockedAccountException();
        }
        //核对用户密码
        //获取用户盐
        ByteSource credentailsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user,user.getPassword()
                        ,credentailsSalt,getName());
        SecurityUtils.getSubject().getSession().setAttribute("userId",user.getId());
        return simpleAuthenticationInfo;
    }

    //用户权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        Integer userId=user.getId();
        //获取角色id
        Integer[] roleIds = userRoleMapper.findRoleByUserId(userId);
        List<Integer> result = new ArrayList<>();
        for (int roleId: roleIds) {
            Integer[] menuId = roleMenuMapper.findMenuByRoleId(roleId);
            for(int meuId: menuId){
                result.add(meuId);
            }
        }
        Integer[] menuIds = new Integer[]{result.size()};
        List<String> per = menuMapper.getPermission((Integer[]) result.toArray(menuIds));
        Set<String> set = new HashSet<>();
        for (String p: per){
            set.add(p);
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(set);
        SecurityUtils.getSubject().getSession().setAttribute("permission",set);
        return simpleAuthorizationInfo;
    }

    //清除缓存
    public void clearAuthz(){
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}

package com.oupu.pss.service.impl;


import com.oupu.pss.dao.UserMapper;
import com.oupu.pss.entity.User;
import com.oupu.pss.service.UserService;
import com.oupu.pss.vo.UserVO;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Classname:NavigetionServiceImpl
 * Package:com.oupu.pss.service.impl
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int queryAccountByAccount(String account) {
        int result=userMapper.queryAccountByAccount(account);
        return result;
    }

    @Override
    public int addUser(User user) {
        String password=user.getPassword();
        String salt = UUID.randomUUID().toString();
        String newPassword=new SimpleHash(
                "SHA-224",password,salt,1)
                .toString();
        user.setPassword(newPassword);
        user.setSalt(salt);
        return   userMapper.addUser(user);
    }

    @Override
    public List<User> findAllUser(String query,int pageNum,int pageRecord) {
        pageNum=(pageNum-1)*pageRecord;
        List<User> list = userMapper.findAllUser(query, pageNum, pageRecord);
        return list;
    }

    @Override
    public int updateValid(int id,short valid) {
        int result=userMapper.updateValid(id,valid);
        return result;
    }
}

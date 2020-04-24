package com.oupu.pss.dao;

import com.oupu.pss.entity.Category;
import com.oupu.pss.entity.User;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface UserMapper {

    public int queryAccountByAccount(String account);
    public int queryEmailByEmail(String email);
    public int addUser(User user);
    public User selectUserByAccount(String account);
    public List<User> findAllUser(String query, int pageNum, int pageRecord);
    public int updateValid(int id, short valid);
}

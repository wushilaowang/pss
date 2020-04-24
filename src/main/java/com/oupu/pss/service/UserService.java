package com.oupu.pss.service;

import com.oupu.pss.entity.Category;
import com.oupu.pss.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Classname:NavigetionService
 * Package:com.oupu.pss.service
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
public interface UserService {
    public int queryAccountByAccount(String account);
    public int addUser(User user);
    public List<User> findAllUser(String query, int pageNum, int pageRecord);
    public int updateValid(int id, short valid);
}

package com.oupu.pss.service;

import com.oupu.pss.entity.Category;
import com.oupu.pss.entity.Navigation;

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
public interface CategoryService {
    public List<Map<String,Object>> findAllCat();
    public int addCat(Category category);
    public int updateCat(Category category);
    public String deleteCat(int id);
}

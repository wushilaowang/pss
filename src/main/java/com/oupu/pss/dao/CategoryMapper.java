package com.oupu.pss.dao;

import com.oupu.pss.entity.Category;
import com.oupu.pss.entity.Detail;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface CategoryMapper {
    public Category findCatById(int id);
    public List<Category> findAllCat();
    public int addCat(Category category);
    public int updateCat(Category category);
    public int deleteCat(int id);

    public void updateCatParent(Integer parent_id);
}

package com.oupu.pss.dao;


import com.oupu.pss.entity.Navigation;

import java.util.List;

/**
 * Classname:GoodsMapper
 * Package:com.oupu.pss.mapper
 * Description:
 *
 * @Data:2019/12/7 17:40
 * @Author:
 */
public interface NavigationMapper {
    public List<Navigation> findParent();
}

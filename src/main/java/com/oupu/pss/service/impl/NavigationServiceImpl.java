package com.oupu.pss.service.impl;

import com.oupu.pss.dao.NavigationMapper;
import com.oupu.pss.entity.Navigation;
import com.oupu.pss.service.NavigationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classname:NavigetionServiceImpl
 * Package:com.oupu.pss.service.impl
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
@Service
public class NavigationServiceImpl implements NavigationService {
    @Autowired
    private NavigationMapper navigetionMapper;

    @Override
    public List<Navigation> findParent() {
        return navigetionMapper.findParent();
    }
}

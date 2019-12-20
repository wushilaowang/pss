package com.oupu.pss.controller;

import com.oupu.pss.entity.Navigation;
import com.oupu.pss.service.NavigationService;
import com.oupu.pss.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classname:NavigetionController
 * Package:com.oupu.pss.controller
 * Description:
 *
 * @Data:2019/12/8 10:16
 * @Author:
 */
@RestController
public class NavigationController {
    @Autowired
    private NavigationService navigationService;

    @RequestMapping("/navigetion/findParent")
    public JsonResult findParent(){
        return new JsonResult("200",navigationService.findParent());
    }
}

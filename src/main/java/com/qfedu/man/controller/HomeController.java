package com.qfedu.man.controller;

import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.Stylist;
import com.qfedu.man.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/2 9:06
 */
@Controller
@Api(description = "首页管理API")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @ApiOperation(value="查询所有设计师")
    @PostMapping("/findAllType.do")
    public JsonBean<Stylist> findAllStylist(){
        List<Stylist> allStylist = homeService.getStylistList();
        return new JsonBean(0,allStylist);
    }
}

package com.qfedu.man.controller;

import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.HomeRecommendSubject;
import com.qfedu.man.entity.Stylist;
import com.qfedu.man.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/2 9:06
 */
@RestController
@Api(description = "首页展示API")
public class HomeController {

    @Autowired
    HomeService homeService;

    @ApiOperation(value="查询所有设计师")
    @PostMapping("/findAllStylist.do")
    public JsonBean<Stylist> findAllStylist(){
        List<Stylist> allStylist = homeService.getStylistList();
        return new JsonBean(0,allStylist);
    }

    @ApiModelProperty(value = "根据id查询设计师")
    @PostMapping("/findStylist.do")
    public JsonBean<Stylist> findStylistById(Integer sid) {
        Stylist stylist = homeService.findStylistById(sid);
        return new JsonBean(0, stylist);
    }

    @ApiModelProperty(value = "查询推荐专题")
    @PostMapping("/findRecommendSubject.do")
    public JsonBean<HomeRecommendSubject> getRecommendSubject(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeRecommendSubject> subjectList = homeService.getSubjectList(pageSize, pageNum);
        return new JsonBean(0, subjectList);
    }
}

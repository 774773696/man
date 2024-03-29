package com.qfedu.man.controller;

import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.Goods;
import com.qfedu.man.entity.GoodsType;
import com.qfedu.man.entity.Type;
import com.qfedu.man.service.GoodsService;
import com.qfedu.man.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@Api(description ="商品管理API")
@RestController
public class GoodsController {

    @Autowired(required = false)
    private GoodsTypeService goodsTypeService;

    @Autowired
    private GoodsService goodsService;


    @ApiOperation(value="查询所有分类")
    @PostMapping("/findAllType.do")
    public JsonBean<Type> findAllType(){
        List<Type> allType = goodsTypeService.findAllType();
        return new JsonBean(0,allType);
    }

    @ApiOperation(value="按分类id查询所有商品类型", notes="必传参数：分类id(tid)")
    @PostMapping("/findByIdGoodsType.do")
    public JsonBean<GoodsType> findByIdGoodsType(Integer tid){
        List<GoodsType> byIdGoodsType = goodsTypeService.findByIdGoodsType(tid);
        return new JsonBean(0,byIdGoodsType);
    }


    @ApiOperation(value="按商品类型id查询所有商品", notes="必传参数：商品类型id(goodstypeIdd)")
    @PostMapping("/findByGoodsTypeId.do")
    public JsonBean<Goods> findByGoodsTypeId(Integer goodstypeId){

        List<Goods> list = goodsService.findByGoodsTypeId(goodstypeId);

        return new JsonBean(0,list);

    }


}

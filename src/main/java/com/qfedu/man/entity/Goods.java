package com.qfedu.man.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("商品表")
public class Goods { //商品表

    @ApiModelProperty(name="gid", value="商品id",dataType = "Integer")
    private Integer gid;//商品id
    @ApiModelProperty(name="goodsName", value="商品名字",dataType = "String")
    private String goodsName;//商品名字
    @ApiModelProperty(name="goodsPrice", value="商品价格",dataType = "Double")
    private Double goodsPrice;//商品价格
    @ApiModelProperty(name="goodsDesc", value="商品描述",dataType = "String")
    private String goodsDesc;//商品描述
    @ApiModelProperty(name="goodsStore", value="商品库存",dataType = "Integer")
    private Integer goodsStore;//商品库存
    @ApiModelProperty(name="goodstypeId", value="商品类型id",dataType = "Integer")
    private Integer goodstypeId;//商品类型id
    @ApiModelProperty(name="createTime", value="商品上架时间",dataType = "Date")
    private Date createTime;//商品上架时间
    @ApiModelProperty(name="sizeId", value="商品尺寸id",dataType = "Integer")
    private Integer sizeId;//商品尺寸id
    @ApiModelProperty(name="goodsColor", value="商品颜色",dataType = "String")
    private String goodsColor;//商品颜色
    @ApiModelProperty(name="goodsOut", value="已售商品",dataType = "Integer")
    private Integer goodsOut;//已售商品
    @ApiModelProperty(name="imgs", value="商品图片",dataType = "Imgs")
    private List<Imgs> imgs;//商品图片







}

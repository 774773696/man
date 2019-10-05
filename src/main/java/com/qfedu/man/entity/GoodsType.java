package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品类型表")
public class GoodsType {

    @ApiModelProperty(name = "goodstypeId",value = "商品id",dataType = "Integer")
    private Integer goodstypeId;

    @ApiModelProperty(name = "goodstypeName",value = "商品名称",dataType = "String")
    private String goodstypeName;

    @ApiModelProperty(name = "bid",value = "品牌id",dataType = "Integer")
    private Integer bid;
}

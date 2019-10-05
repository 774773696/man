package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商家表")
public class Merchant {
    @ApiModelProperty(name = "mid",value = "商家id",dataType = "Integer")
    private Integer mid;
    @ApiModelProperty(name = "merchantName",value = "商家店铺名称",dataType = "String")
    private String merchantName;
}

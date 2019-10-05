package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("品牌表")
public class Brand {
    @ApiModelProperty(name = "bid",value = "品牌id",dataType = "Integer")
    private Integer bid;

    @ApiModelProperty(name = "brandName",value = "品牌名称",dataType = "String")
    private String brandName;

}

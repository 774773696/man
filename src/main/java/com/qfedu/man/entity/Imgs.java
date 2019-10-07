package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("图片表")
public class Imgs {
    @ApiModelProperty(name = "imgId",value = "图片id",dataType = "Integer")
    private Integer imgId;

    @ApiModelProperty(name = "imgUrl",value = "图片链接地址",dataType = "String")
    private String imgUrl;


    @ApiModelProperty(name = "gid",value = "商品id",dataType = "Integer")
    private Integer gid;


}

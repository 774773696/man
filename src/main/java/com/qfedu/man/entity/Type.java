package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分类表")
public class Type {
    @ApiModelProperty(name = "tid",value = "分类id",dataType = "Integer")
    private Integer tid;

    @ApiModelProperty(name = "typeName",value = "分类名称",dataType = "String")
    private String typeName;

}

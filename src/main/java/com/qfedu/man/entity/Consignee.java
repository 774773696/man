package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("收货人表")
public class Consignee {
    @ApiModelProperty(name = "cid",value = "收货人id",dataType = "Integer")
    private Integer cid;
    @ApiModelProperty(name = "consigneeName",value = "收货人名称",dataType = "String")
    private String consigneeName;
    @ApiModelProperty(name = "consigneePhone",value = "收货人联系方式",dataType = "String")
    private String consigneePhone;
    @ApiModelProperty(name = "consigneeAddress",value = "收货人地址",dataType = "String")
    private String consigneeAddress;
    @ApiModelProperty(name = "uid",value = "用户id",dataType = "Integer")
    private Integer uid;


}

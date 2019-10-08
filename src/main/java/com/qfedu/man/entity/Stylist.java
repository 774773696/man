package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/1 9:25
 */
@Data
@ApiModel("设计师表")
public class Stylist {
    @ApiModelProperty(name = "sid", value = "设计师id", dataType = "Integer")
    private Integer sid;
    @ApiModelProperty(name = "stylistName", value = "设计师名字", dataType = "String")
    private String stylistName;
    @ApiModelProperty(name = "stylistImage", value = "设计师图片url", dataType = "String")
    private String stylistImage;
}

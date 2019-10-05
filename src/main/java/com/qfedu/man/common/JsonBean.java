package com.qfedu.man.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class JsonBean<T> {


    @ApiModelProperty(value = "返回数据状态编码，0正常返回，1失败")
    private int code;
    @ApiModelProperty(value = "表示返回的具体数据，可以为null")
    private T info;

}

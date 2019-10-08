package com.qfedu.man.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/1 11:28
 * 专题实体类
 */
@Data
@ApiModel("专题分类表")
public class HomeRecommendSubject {
    @ApiModelProperty(name = "subjectId",value = "专题id",dataType = "Integer")
    private Integer subjectId;
    @ApiModelProperty(name = "recommendStatus",value = "专题状态",dataType = "Integer")
    private Integer recommendStatus;
    @ApiModelProperty(name = "description",value = "专题详情",dataType = "String")
    private String description;
    @ApiModelProperty(name = "pic",value = "专题图片url",dataType = "String")
    private String pic;
    @ApiModelProperty(name = "categotyName",value = "专题名称",dataType = "String")
    private String categotyName;
    @ApiModelProperty(name = "title",value = "专题标题",dataType = "String")
    private String title;

}

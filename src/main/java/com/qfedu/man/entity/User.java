package com.qfedu.man.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel("用户表")
public class User { //用户表

    @ApiModelProperty(name="uid", value="用户id",dataType = "Integer")
    private Integer uid;//用户id
    @ApiModelProperty(name="phone", value="用户手机号",dataType = "String")
    private String phone;//用户手机号
    @ApiModelProperty(name="password", value="用户密码",dataType = "String")
    private String password;//用户密码
    @ApiModelProperty(name="qq", value="用户qq",dataType = "String")
    private String qq;//用户qq号码
    @ApiModelProperty(name="wechat", value="用户微信号",dataType = "String")
    private String wechat;//用户微信
    @ApiModelProperty(name="address", value="用户地址",dataType = "String")
    private String address;//用户地址
    @ApiModelProperty(name="status", value="用户状态",dataType = "Integer")
    private Integer status;//用户状态
    @ApiModelProperty(name="username", value="用户昵称",dataType = "String")
    private String username;//用户昵称
    @ApiModelProperty(name="sex", value="用户性别",dataType = "String")
    private String sex;//用户性别
    @ApiModelProperty(name="imgUrl", value="用户头像图片路径",dataType = "String")
    private String imgUrl;
}

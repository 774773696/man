package com.qfedu.man.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order { //订单表

    private Integer orderId;//订单id
    private Integer goodsId;//商品id
    private Double totalPrice;//订单总价
    private Date createTime;//订单生成时间
    private Integer status;//订单状态
    private Integer uid;//用户id


}

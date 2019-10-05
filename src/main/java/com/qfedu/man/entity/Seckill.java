package com.qfedu.man.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Seckill {  //秒杀表

    private Integer seckillId;//秒杀id
    private Integer goodsId;//商品id
    private Double seckillPrice;//秒杀价格
    private Integer seckillStock;//秒杀剩余库存
    private Date  beginTime;//秒杀开始时间
    private Date endTime;//秒杀结束时间
    private String seckillUrl;//秒杀地址
    private Integer version; //秒杀版本
}

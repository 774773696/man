package com.qfedu.man.dao;

import com.qfedu.man.entity.Goods;

import java.util.List;

public interface GoodsDao {

    //根据商品类型id 找到商品
    public List<Goods> findByGoodsTypeId(Integer goodstypeId);

}

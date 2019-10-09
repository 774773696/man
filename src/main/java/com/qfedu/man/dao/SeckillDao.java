package com.qfedu.man.dao;

import com.qfedu.man.entity.SeckillGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeckillDao {

    public List<SeckillGoods> findAll();

    public SeckillGoods findById(Integer sid);

    public void updateStockById(Integer sid);

    public int getStock(Integer sid);

    //更新生成的静态页面的url
    public void updateUrlById(@Param("sid") Integer sid, @Param("url") String url);
}

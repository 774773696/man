package com.qfedu.man.dao;

import com.qfedu.man.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> findById(Integer tid);
}

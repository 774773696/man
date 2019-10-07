package com.qfedu.man.service;

import com.qfedu.man.entity.GoodsType;
import com.qfedu.man.entity.Type;

import java.util.List;

public interface GoodsTypeService {
    public List<Type> findAllType();
    public List<GoodsType> findByIdGoodsType(Integer tid);
}

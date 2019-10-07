package com.qfedu.man.service.impl;

import com.qfedu.man.dao.GoodsTypeDao;
import com.qfedu.man.dao.TypeDao;
import com.qfedu.man.entity.GoodsType;
import com.qfedu.man.entity.Type;
import com.qfedu.man.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired(required = false)
    GoodsTypeDao goodsTypeDao;

    @Autowired(required = false)
    TypeDao typeDao;

    @Override
    public List<Type> findAllType(){
        List<Type> allType = typeDao.findAllType();
        if (allType != null){
            return allType;
        }else {
            throw new RuntimeException("查询分类异常");
        }
    }

    @Override
    public List<GoodsType> findByIdGoodsType(Integer tid){
        List<GoodsType> allGoodsType = goodsTypeDao.findById(tid);
        if(allGoodsType != null){
            return allGoodsType;
        }else {
            throw new RuntimeException("查询商品类型异常");
        }
    }
}

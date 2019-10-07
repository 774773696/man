package com.qfedu.man.service.impl;

import com.qfedu.man.dao.GoodsDao;
import com.qfedu.man.entity.Goods;
import com.qfedu.man.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired(required = false)
    private GoodsDao goodsDao;


    @Override
    public List<Goods> findByGoodsTypeId(Integer goodstypeId) {


        List<Goods> list = goodsDao.findByGoodsTypeId(goodstypeId);

        if (list == null){
            throw  new RuntimeException("商品为空");
        }

        return list;
    }
}

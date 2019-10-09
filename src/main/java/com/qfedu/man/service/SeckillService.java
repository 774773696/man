package com.qfedu.man.service;


import com.qfedu.man.entity.SeckillGoods;

import java.util.List;
import java.util.Map;

public interface SeckillService {
    public List<SeckillGoods> findAllSeckillGoods();

    public Map<String, Object> findSeckillGoodsById(Integer sid);


    public void buySeckillGoods(Integer uid, Integer sid);

    //--------------静态化--------------
    //根据秒杀商品的id 仅获取秒杀商品的信息
    public SeckillGoods findSeckillGoodsBySid(Integer sid);

    //更新静态页面的路径
    public void updateSeckillUrlBySid(Integer sid, String url);

    public Map<String, Object> findSeckillGoodsById2(Integer sid);

}

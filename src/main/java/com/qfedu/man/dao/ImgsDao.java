package com.qfedu.man.dao;

import com.qfedu.man.entity.Imgs;

import java.util.List;

public interface ImgsDao {



    public List<Imgs> findByGoodsId(Integer gid);
}

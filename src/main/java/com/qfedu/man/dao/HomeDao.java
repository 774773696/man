package com.qfedu.man.dao;

import com.qfedu.man.entity.HomeRecommendSubject;
import com.qfedu.man.entity.Stylist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/1 9:08
 * 首页内容管理
 */
public interface HomeDao {
    // 查询所有设计师
    List<Stylist> findAll();
    // 根据id查询设计师
    Stylist findStylistById(Integer sid);

    // 获取推荐专题
    List<HomeRecommendSubject> findAllRecommendSubject(@Param("offset") Integer offset, @Param("limit") Integer limit);
}

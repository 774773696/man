package com.qfedu.man.dao;

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
    List<Stylist> findAll();
}

package com.qfedu.man.service;

import com.qfedu.man.entity.HomeRecommendSubject;
import com.qfedu.man.entity.Stylist;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/09/30 9:44
 */
public interface HomeService {
    /**
     * 获取设计师列表
     * @return
     */
  public List<Stylist> getStylistList();

    /**
     * 根据id查询设计师
     * @param sid
     * @return
     */
    public Stylist findStylistById(Integer sid);

    /**
     * 获取推荐专题
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<HomeRecommendSubject> getSubjectList(Integer pageSize, Integer pageNum);
}

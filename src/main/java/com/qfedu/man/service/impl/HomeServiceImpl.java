package com.qfedu.man.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.man.dao.HomeDao;
import com.qfedu.man.entity.HomeRecommendSubject;
import com.qfedu.man.entity.Stylist;
import com.qfedu.man.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/09/30 9:47
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired(required = false)
    private HomeDao homeDao;

    @Override
    public List<Stylist> getStylistList() {
        List<Stylist> allStylist = homeDao.findAll();
        if (allStylist != null) {
            return allStylist;
        }else {
            throw new RuntimeException("查询设计师异常");
        }
    }

    @Override
    public Stylist findStylistById(Integer sid) {
        Stylist stylist = homeDao.findStylistById(sid);
        if (stylist != null) {
            return stylist;
        } else {
            throw new RuntimeException("查询设计师异常");
        }

    }

    @Override
    public List<HomeRecommendSubject> getSubjectList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return homeDao.findAllRecommendSubject(pageSize, pageNum);
    }
}

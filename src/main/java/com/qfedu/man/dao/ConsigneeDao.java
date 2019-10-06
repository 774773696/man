package com.qfedu.man.dao;

import com.qfedu.man.entity.Consignee;

import java.util.List;

public interface ConsigneeDao {
    public List<Consignee> findByUserId(Integer uid);

    public void addConsignee(Consignee consignee);

    public void updateConsignee(Consignee consignee);
    public void delConsignee(Integer cid);
}

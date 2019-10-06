package com.qfedu.man.service;


import com.qfedu.man.entity.Consignee;
import com.qfedu.man.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {


    public User login(String phone,String password); //用户登录

    public void addUser(User user);//增加用户

    public User findByPhone(String phone);//查询用户

    public void updatePassword(String phone,String password);//修改密码




    public void updateUser(User user);

    public void updateUserImg(String phone, MultipartFile upload);//修改用户




//    收获地址查询
    public List<Consignee> findAllConsignee(Integer uid);

    //    添加或修改收获地址
    public void userAddOrUpdateConsignee(Consignee consignee);
    //    删除收获地址
    public void delUserConsignee(Integer cid);
}

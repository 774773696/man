package com.qfedu.man.service;


import com.qfedu.man.entity.User;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {


    public User login(String phone,String password); //用户登录

    public void addUser(User user);//增加用户

    public User findByPhone(String phone);//查询用户

    public void updatePassword(String phone,String password);//修改密码




    public void updateUser(User user);

    public void updateUserImg(String phone, MultipartFile upload);//修改用户
}

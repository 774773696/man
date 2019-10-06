package com.qfedu.man.dao;


import com.qfedu.man.entity.User;


public interface UserDao {

    public User findById(Integer uid);

    public User findByPhone(String phone); //查询单个用户

    public void addUser(User user);//添加用户

    public void updatePassword(String phone,String password);//修改密码

    public void updateUserImg(String imgUrl,String phone);//修改用户
    public void updateUserName(String  username,String phone);//修改用户
    public void updateUserSex(String  sex,String phone);//修改用户
}

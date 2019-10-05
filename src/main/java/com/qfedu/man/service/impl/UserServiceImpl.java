package com.qfedu.man.service.impl;

import com.qfedu.man.dao.UserDao;
import com.qfedu.man.entity.User;
import com.qfedu.man.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false) //处理报红的问题
    private UserDao userDao;

    @Override
    public User login(String phone, String password) {
        User user = userDao.findByPhone(phone);
        if (user == null){
            throw new RuntimeException("手机号错误");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        User user1 = userDao.findByPhone(user.getPhone());
        if (user1 == null){
            userDao.addUser(user);
        }else{
            throw new RuntimeException("手机号已存在");
        }

    }


    @Override
    public User findByPhone(String phone) {
        User user = userDao.findByPhone(phone);
        if (user == null){
            throw new RuntimeException("无此数据");
        }
        return user;
    }

    @Override
    public void updatePassword(String phone, String password) {

        userDao.updatePassword(phone,password);
    }





    @Override
    public void updateUser(User user) {
        User byPhone = userDao.findByPhone(user.getPhone());
        if(!byPhone.getUsername().equals(user.getUsername())){
            userDao.updateUserName(user.getUsername(),user.getPhone());
        }
        if(!byPhone.getSex().equals(user.getSex())){
            userDao.updateUserSex(user.getSex(),user.getPhone());
        }
    }

    @Override
    public void updateUserImg(String phone, MultipartFile upload) {
        User byPhone = userDao.findByPhone(phone);

        String path = "C:\\Users\\YU/imgs";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        try {
            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byPhone.setImgUrl("C:\\Users\\YU\\imgs/"+filename);

        userDao.updateUserImg(byPhone.getImgUrl(),byPhone.getPhone());
    }


}

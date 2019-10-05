package com.qfedu.man.controller;


import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.User;
import com.qfedu.man.service.UserService;
import com.qfedu.man.utils.MD5Utils;
import com.qfedu.man.utils.PhoneCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

//@CrossOrigin
@Api(description ="用户管理API")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value="用户登录接口", notes="手机号,密码登录,登录成功会生成token发送给前台保存")
    @PostMapping("/login")
    public JsonBean login(@RequestParam("phone") String phone, @RequestParam("password") String password){

        User user = userService.login(phone, password);

        if (user == null){
            return new JsonBean(1,"未登录");
        }
        //生成token并加盐
        String token = MD5Utils.md5(phone + "haha");
        //存到redis中
        stringRedisTemplate.opsForValue().set(token,phone);
        //过期时间为30分钟
        stringRedisTemplate.expire(token,30, TimeUnit.MINUTES);


        return new JsonBean(0,token);
    }

    //短信验证码
    @PostMapping("/phoneCode")
    @ApiOperation(value="生成短信验证码接口", notes="需要电话号码为参数，验证码有效时间五分钟")
    public JsonBean phoneCode(String phone){
        PhoneCode.setNewcode();
        String code = String.valueOf(PhoneCode.getNewcode());

        try{
            PhoneCode.sendSms(phone,code);
        }catch(Exception e){
            e.printStackTrace();
        }
        //短信验证码放入redis中 时效5分钟
        stringRedisTemplate.opsForValue().set("code",code);
        stringRedisTemplate.expire(code,5,TimeUnit.MINUTES);

        return new JsonBean(0,null);
    }

    //效验验证码
    @PostMapping("/codeVerify")
    @ApiOperation(value="效验验证码接口", notes="需要电话号码验证码为参数，成功返回给页面用户的手机号")
    public JsonBean codeVerify(String phone,String code){

        String code1 = stringRedisTemplate.opsForValue().get("code");

        if (code1 == null){
            return new JsonBean(1,"验证码失效");
        }
        if (!code1.equals(code)){
            return new JsonBean(1,"验证码错误");
        }
        if (code == null || code == ""){
            return new JsonBean(1,"验证码不能为空");
        }

        User user = new User();

        user.setPhone(phone);
        user.setUsername("男人帮"+phone);
        user.setSex("男");
        user.setImgUrl("http:123.57.95.40:8889/imgs/man.jpg");
        userService.addUser(user);

        return new JsonBean(0,phone);
    }

    //用户注册成功，添加账户密码
    @PostMapping("/updatePassword")
    @ApiOperation(value="用户注册成功，添加密码接口", notes="需要电话号码密码为参数，成功返回给前端提示信息‘添加密码成功’")
    public JsonBean updatePassword(String phone,String password){

        userService.updatePassword(phone, password);

        return new JsonBean(0,"添加密码成功");
    }




    @ApiOperation(value="用户修改昵称性别接口", notes="需要user类型(phone参数必须有)参数，只修改用户昵称，性别")
    @PostMapping("/updateUser.do")
    public JsonBean updateUser(User user){

        userService.updateUser(user);

        return new JsonBean(0,"修改成功");
    }
    @ApiOperation(value="用户修改头像接口", notes="用户手机号、头像文件参数 修改用户头像")
    @PostMapping("/updateUserImg.do")
    public JsonBean updateUserImg(String phone, MultipartFile upload){

        userService.updateUserImg(phone,upload);

        return new JsonBean(0,"修改成功");
    }


}

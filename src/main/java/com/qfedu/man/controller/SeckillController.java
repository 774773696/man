package com.qfedu.man.controller;


import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.SeckillGoods;
import com.qfedu.man.entity.User;
import com.qfedu.man.service.SeckillService;
import com.qfedu.man.service.UserService;
import com.qfedu.man.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private UserService userService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/seckill/list")
    public String listSeckillGoods(Model model){
        List<SeckillGoods> list = seckillService.findAllSeckillGoods();

        String imgUrl = list.get(0).getGoods().getImgs().get(0).getImgUrl();

        System.out.println("========================================");
        System.out.println(imgUrl);
        System.out.println("========================================");

        model.addAttribute("seckillList", list);
        model.addAttribute("imgUrl", imgUrl);
        return "seckillList";
    }

    @RequestMapping("/seckill/detail")
    public String findSeckillGoodsById(Integer sid, Model model){

        Map<String, Object> map = seckillService.findSeckillGoodsById(sid);
        model.addAttribute("seckillInfo", map);

        return "seckillDetail";

    }

    @RequestMapping("/seckill/buy")
    public String buySeckillGoods(String phone, Integer sid,String info, HttpServletRequest request) {

        String token = request.getHeader("token");
        if(token == null){
            throw new RuntimeException("未登陆");
        }
        User user = userService.findByPhone(phone);


        String md5Info = MD5Utils.md5("sid" + sid);
        if(md5Info.equals(info)){
            seckillService.buySeckillGoods(user.getUid(), sid);
        }else {
            throw new RuntimeException("秒杀失败");
        }
        return "redirect:/orders?uid=" + user.getUid();

    }


/*      @RequestMapping("/seckill/buy")
        public String buySeckillGoods(Integer sid, HttpSession session){

        User user = (User)session.getAttribute("loginuser");
        if(user == null){
            throw new RuntimeException("未登陆");
        }
        seckillService.buySeckillGoods(user.getUid(), sid);

        return "redirect:/orders?uid=" + user.getUid();
    }*/

    /**
     * 详情页面静态化后，获取库存/秒杀状态等数据
     * @param sid
     * @return
     */

    @RequestMapping("/seckillinfo")
    @ResponseBody
    public JsonBean seckillInfo(Integer sid){
        Map<String, Object> map = seckillService.findSeckillGoodsById2(sid);
        return new JsonBean(0,map);
    }

    /**
     * 暴露要购买的商品的id信息（MD5处理）
     * @param sid
     * @return
     */
    @RequestMapping("/seckillurl")
    @ResponseBody
    public JsonBean seckillurl(Integer sid){
        //按照获取库存和秒杀状态信息的方法，根据时间段判断状态，决定是否返回MD5处理的值
        String md5Url = MD5Utils.md5("sid" + sid);
        return new JsonBean(0,md5Url);
    }

    /**
     * 测试超卖的现象
     * @param uid
     * @param sid
     * @return
     */

    @RequestMapping("/test/buy")
    @ResponseBody
    public JsonBean buySeckillGoods1(Integer uid,Integer sid) {
       seckillService.buySeckillGoods(uid,sid);

       return new JsonBean(0,null );
    }
}

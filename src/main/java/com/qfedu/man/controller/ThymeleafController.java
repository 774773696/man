package com.qfedu.man.controller;



import com.qfedu.man.common.CodeMsg;
import com.qfedu.man.common.ErrorCode;
import com.qfedu.man.common.JsonBean;
import com.qfedu.man.entity.SeckillGoods;
import com.qfedu.man.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//
@RestController
public class ThymeleafController {
    @Autowired
    @Qualifier("myTemplateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private CodeMsg codeMsg;


    @RequestMapping("/createHtml")
    public JsonBean createHtml(Integer sid){
        //1.查询秒杀商品的信息
        SeckillGoods seckillGoods = seckillService.findSeckillGoodsBySid(sid);

        //2.创建Thymeleaf的Context对象,设置模板需要使用的数据
        Context context = new Context();
        context.setVariable("seckillGoods",seckillGoods);

        //如：seckillDetail_s1.html
        String fileName = "seckillDetail_s"+sid+".html";

        //获取classes目录的实际路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        path +="/static";

        File file = new File(path,fileName);
        //如果文件存在，删除文件
        if(file.exists()){
            file.delete();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            //3.生成静态页面，（放在target--classes--static目录下）
            //第一个参数：模板引擎的名称
            //第二个参数：thymeleaf的上下文对象，里面村的是需要的
            //第三个参数：生成的HTML文件的Writer对象
            templateEngine.process("seckillDetail_s",context,writer);

            //修改url字段
            seckillService.updateSeckillUrlBySid(sid,fileName);

        } catch (IOException e) {
            e.printStackTrace();
            return new JsonBean(ErrorCode.CREATE_HTML_ERROR,codeMsg.getCreateHtmlError());
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        return new JsonBean(0,null);
     }




}

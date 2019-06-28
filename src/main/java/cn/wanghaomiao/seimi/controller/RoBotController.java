package cn.wanghaomiao.seimi.controller;

import cn.wanghaomiao.seimi.crawlers.SimpleDemo;
import cn.wanghaomiao.seimi.robot.HelloBot;
import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.api.MessageTools;
import cn.zhouyafeng.itchat4j.api.WechatTools;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import io.github.biezhi.wechat.api.constant.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class RoBotController {
    @RequestMapping("/robot")
    public String helloRobot(){
        new HelloBot(Config.me().autoLogin(true).showTerminal(true)).start();
        return "success";
    }
    @RequestMapping("/test")
    public String test(){
        String qrPath = "D://login"; // 保存登陆二维码图片的路径，这里需要在本地新建目录
        IMsgHandlerFace msgHandler = new SimpleDemo(); // 实现IMsgHandlerFace接口的类
        Wechat wechat = new Wechat(msgHandler, qrPath); // 【注入】
        wechat.start(); // 启动服务，会在qrPath下生成一张二维码图片，扫描即可登陆，注意，二维码图片如果超过一定时间未扫描会过期，过期时会自动更新，所以你可能需要重新打开图片
        MessageTools.sendMsgByNickName("刘纬泉","D://1.jpg");
        return "111";
    }
    @RequestMapping("/message")
    public String message(){
        String str = WechatTools.getUserNameByNickName("一条酸菜鱼");
        File file = new File("C://picture");
        File[] list = file.listFiles();
        System.out.println("list.size:"+list.length);
        MessageTools.sendPicMsgByNickName("一条酸菜鱼","D://1.jpg");
        MessageTools.sendFileMsgByUserId(str,"D://1.jpg");
        System.out.println("str:"+str);
        return "111";

    }
}

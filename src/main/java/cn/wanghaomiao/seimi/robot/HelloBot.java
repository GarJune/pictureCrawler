package cn.wanghaomiao.seimi.robot;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;

public class HelloBot extends WeChatBot {

    public HelloBot(Config config) {
        super(config);
    }

    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        System.out.println("人名："+message.getFromNickName());
        if (message.getFromNickName().equals("一条酸菜鱼")) {
            System.out.println(String.format("接收到 [%s] 的消息: %s", message.getFromUserName(), message.getText()));
            this.sendMsg(message.getFromUserName(),  message.getText()+"!");
            boolean result =  this.sendImgName(message.getFromNickName(),"http://ww1.sinaimg.cn/bmiddle/9150e4e5gy1g3gq0cy1myj206o04lwei.jpg");
            System.out.println("result:"+result);
        }
        this.sendImg(message.getMineUserName(), "D:\\1.jpg");

    }
    @Bind(accountType = AccountType.TYPE_GROUP)
    public void handleGroup(WeChatMessage message) {
        if (message.getFromNickName().equals("天台蹦迪要着衫")) {
            this.sendImg(message.getFromUserName(), "D:\\1.jpg");
            this.sendImg(message.getName(), "http://ww1.sinaimg.cn/bmiddle/9150e4e5gy1g3gq0cy1myj206o04lwei.jpg");
            this.sendImgName(message.getFromRemarkName(), "D:\\1.jpg");
            boolean result =  this.sendImgName(message.getFromNickName(),"D:\\1.jpg");
        }
    }

}
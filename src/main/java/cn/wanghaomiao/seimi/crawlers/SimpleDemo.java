package cn.wanghaomiao.seimi.crawlers;

import cn.zhouyafeng.itchat4j.api.MessageTools;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import com.alibaba.fastjson.JSONObject;


public class SimpleDemo implements IMsgHandlerFace {

    @Override
    public String textMsgHandle(JSONObject jsonObject) {
        System.out.println("wechat object:"+jsonObject);
        System.out.println("here");
        MessageTools.sendPicMsgByNickName("一条酸菜鱼","D://1.jpg");
        MessageTools.sendMsgByNickName("一条酸菜鱼","D://1.jpg");
        MessageTools.sendPicMsgByNickName("一条酸菜鱼","D://1.jpg");
        MessageTools.sendPicMsgByNickName("天台蹦迪要着衫  ","D://1.jpg");
        return "here";
    }

    @Override
    public String picMsgHandle(JSONObject jsonObject) {
        return null;
    }

    @Override
    public String voiceMsgHandle(JSONObject jsonObject) {
        return null;
    }

    @Override
    public String viedoMsgHandle(JSONObject jsonObject) {
        return null;
    }

    @Override
    public String nameCardMsgHandle(JSONObject jsonObject) {
        return null;
    }
}

package cn.wanghaomiao.seimi.controller;

import cn.wanghaomiao.seimi.crawlers.DefaultPipeline;
import cn.wanghaomiao.seimi.crawlers.FaBiaoQingPageCrawler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@RestController
public class FaBiaoQingController {
    @RequestMapping("/fabiaoqing")
    public String FaBiaoQingCrawler(Integer start,Integer end){
        Spider spider = Spider.create(new FaBiaoQingPageCrawler());
        for(int i=start;i<end;i++){
            spider.addUrl("https://fabiaoqing.com/bqb/lists/type/duiren/page/"+i+".html");
        }
          spider.addPipeline(new DefaultPipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
        return "success";
    }
}

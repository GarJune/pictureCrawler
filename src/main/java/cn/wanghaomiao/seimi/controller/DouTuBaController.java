package cn.wanghaomiao.seimi.controller;

import cn.wanghaomiao.seimi.crawlers.DefaultPipeline;
import cn.wanghaomiao.seimi.crawlers.DouTuBaPageCrawler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@RestController
public class DouTuBaController {
    @RequestMapping("doutuba")
    public String douTuBaCrawler(Integer start,Integer end){
        Spider spider = new Spider(new DouTuBaPageCrawler());
        for(int i=start;i<end;i++){
            spider.addUrl("https://www.doutula.com/photo/list/?page="+i);
        }
        spider.addPipeline(new DefaultPipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
        return "success";
    }
}

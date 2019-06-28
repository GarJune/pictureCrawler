package cn.wanghaomiao.seimi.crawlers;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class DouTuBaPageCrawler implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> urls =  page.getHtml().xpath("//a[@class='col-xs-6 col-sm-3']/img/@data-original").all();
        List<String> urlNames =  page.getHtml().xpath("//a[@class='col-xs-6 col-sm-3']/img/@alt").all();
        page.putField("img",urls);
        page.putField("imgName",urlNames);
    }

    @Override
    public Site getSite() {
        return site;
    }
}

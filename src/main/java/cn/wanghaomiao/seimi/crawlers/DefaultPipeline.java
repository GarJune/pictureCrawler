package cn.wanghaomiao.seimi.crawlers;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;


public class DefaultPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> list = resultItems.get("img");
        List<String> nameList = resultItems.get("imgName");
        UrlFileDownloadUtil.downloadPictures(list,nameList);
    }
}

package cn.wanghaomiao.seimi.crawlers;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UrlFileDownloadUtil {
    /**
     * 传入要下载的图片的url列表，将url所对应的图片下载到本地
     */
    public static void downloadPictures(List<String> urlList, List<String> names) {
        String baseDir = "C:\\picture\\";
        URL url = null;
        for (int i = 0; i < urlList.size(); i++) {
            try {
                String urlStr = urlList.get(i);
                if(StringUtils.isEmpty(urlStr)){
                    continue;
                }
                System.out.println("url:"+urlStr);
                url = new URL(urlStr);
                String indexName = urlStr.substring(urlStr.lastIndexOf("."));
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String path = baseDir + names.get(i)+indexName;
                path = path.replaceAll("\\?|\\*|。|,|，","");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(path));

                byte[] buffer = new byte[1024 * 50];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                System.out.println("已经下载：" + path);
                dataInputStream.close();
                fileOutputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadPictures(List<String> urlList) {
        String baseDir = "C:\\picture\\";
        URL url = null;

        for (int i = 0; i < urlList.size(); i++) {
            try {
                String[] files = urlList.get(i).split("/");
                String name = files[files.length - 1];
                url = new URL(urlList.get(i));
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(baseDir + name+"."));

                byte[] buffer = new byte[1024 * 50];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                System.out.println("已经下载：" + baseDir + name);
                dataInputStream.close();
                fileOutputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 下载一张图片
    public static void downloadPicture(String u, String name) {
        String baseDir = "E:\\spider\\";
        URL url = null;

        try {
            url = new URL(u);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(baseDir + name));

            byte[] buffer = new byte[1024 * 50];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            System.out.println("已经下载：" + baseDir + name);
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 下载一张图片
    public static void downloadPicture(String u) {
        String baseDir = "E:\\spider\\";
        URL url = null;
        String[] files = u.split("/");
        String name = files[files.length - 1];

        try {
            url = new URL(u);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(baseDir + name));

            byte[] buffer = new byte[1024 * 50];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            System.out.println("已经下载：" + baseDir + name);
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

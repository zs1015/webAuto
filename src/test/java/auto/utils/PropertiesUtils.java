package auto.utils;

import auto.base.BaseCases;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/10 23:54
 */
public class PropertiesUtils {

    private static Properties urlProperties = new Properties();
    private static Properties configProperties = new Properties();

    //只加载配置文件一次
    static {
        try {
            urlProperties.load(BaseCases.class.getResourceAsStream("/config/url.properties"));
            configProperties.load(BaseCases.class.getResourceAsStream("/config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向外提供get方法
    public static String getUrl(String urlKey) {
        return urlProperties.getProperty(urlKey);
    }

    //向外提供get方法
    public static String getConfig(String urlKey) {
        return configProperties.getProperty(urlKey);
    }

    public static void main(String[] args) {
        System.out.println(getUrl("login_url"));
        System.out.println(getConfig("abc"));
    }
}

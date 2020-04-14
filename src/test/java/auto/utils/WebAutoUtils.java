package auto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author ZS
 * @Description: web自动化工具类
 * @date 2020/4/8 23:58
 */
public class WebAutoUtils {

    /**
     * 获取driver的分发方法
     * @param browserName 浏览器名
     * @param seleniumVersion selenium版本号
     * @return
     */
    public static WebDriver getDriver(String browserName, String seleniumVersion) {
        WebDriver driver = null;
        if ("Chrome".equals(browserName)) {
            return getChromeDriver();
        } else if ("FireFox".equals(browserName)) {
            return getFIreFoxDriver(seleniumVersion);
        } else if ("IE".equals(browserName)) {
            return getIEDriver();
        } else if ("Edge".equals(browserName)) {
            return getEdgeDriver();
        } else {
            throw new RuntimeException("无此浏览器");
        }
    }

    private static WebDriver getEdgeDriver() {
        System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "src/test/resources/driver/MicrosoftWebDriver.exe");
        return new EdgeDriver();
    }

    private static WebDriver getIEDriver() {
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "src/test/resources/driver/IEDriverServer.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);//设置忽略缩放
        desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//忽略安全域设置
        //指定一个初始化页面，保持窗口，防止window窗口丢失
        desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");
        return new InternetExplorerDriver(desiredCapabilities);
    }

    private static WebDriver getFIreFoxDriver(String seleniumVersion) {
        if (!"2.X".equals(seleniumVersion)) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
            return new FirefoxDriver();
        }
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        return new ChromeDriver();
    }
}

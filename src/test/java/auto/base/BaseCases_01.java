package auto.base;

import auto.utils.PropertiesUtils;
import auto.utils.WebAutoUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author ZS
 * @Description: 基础测试类
 * @date 2020/4/9 22:48
 */
public class BaseCases_01 {
    public static WebDriver driver = null;

    //初始化打开一个浏览器
    @BeforeSuite
    public void beforeSuite() {
        String browserName = "Chrome";
        String seleniumVersion = "3.X";
        driver = WebAutoUtils.getDriver(browserName, seleniumVersion);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        //执行用例完成后，关闭
        try {
            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  打开页面url
     * @param urlKey 对应的属性配置文件名字
     */
    public void to(String urlKey) {
        String url = PropertiesUtils.getUrl(urlKey);
        driver.get(url);
    }

    /**
     * 点击元素
     * @param by By的元素定位器
     */
    public void click(By by) {
        driver.findElement(by).click();
    }

    /**
     *  输内容
     * @param by By的元素定位器
     * @param content 内容
     */
    public void send(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    /**
     *  获取文本；
     * @param by By的元素定位器
     * @return
     */
    public String getTips(By by) {
        return driver.findElement(by).getText();
    }

}

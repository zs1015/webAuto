package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


/**
 * @author ZS
 * @Description:
 * @date 2020/4/5 22:36
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        /*System.setProperty("webdriver.firefox.bin", "D:\\baseSoft\\Firefox46\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("你好");
        driver.findElement(By.id("su")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "src/test/resources/driver/MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("你好");
        driver.findElement(By.id("su")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();*/
        //IE
        /*System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "src/test/resources/driver/IEDriverServer.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);//设置忽略缩放
        desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//忽略安全域设置
        //指定一个初始化页面，保持窗口，防止window窗口丢失
        desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");
        InternetExplorerDriver driver = new InternetExplorerDriver(desiredCapabilities);
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("你好");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        driver.quit();*/

        /*System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("你好");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        driver.quit();*/

        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        //WebElement element = driver.findElement(By.id("kw"));
        //element.sendKeys("你好");
        //driver.findElement(By.id("su")).click();

        //cssSelector
        //driver.findElement(By.cssSelector("input[id='kw'][class='s_ipt']")).sendKeys("你的技术开发能力是");
        //driver.findElement(By.xpath("//*[@name='wd']")).sendKeys("你的技术开发能力是");
        driver.findElement(By.xpath("//*[contains(@id,'kw')]")).sendKeys("你的技术开发能力是");

        //driver.findElement(By.linkText());精确匹配
        //driver.findElement(By.partialLinkText());模糊匹配
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.quit();
    }

}

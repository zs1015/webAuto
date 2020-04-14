package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/8 22:57
 */
public class Test1 {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://www.12306.cn/index/");
        String js = "document.getElementById('train_date').removeAttribute('readonly')";
        Thread.sleep(2000);
        driver.executeScript(js);//执行js脚本
        driver.findElement(By.id("train_date")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("train_date")).sendKeys("2020-04-28");
        Thread.sleep(2000);*/


        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.get("https://ke.qq.com/");
        String js = "window.scroll(0,document.body.scrollHeight);";
        Thread.sleep(2000);
        javascriptExecutor.executeScript(js);
        Thread.sleep(2000);

        driver.quit();


    }


}

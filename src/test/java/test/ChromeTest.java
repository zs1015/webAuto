package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author ZS
 * @Description:
 * @date 2020/4/6 14:06
 */
public class ChromeTest {
    public static void main(String[] args) throws InterruptedException {

        /*System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("class-manage")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("一周排课")).click();
        Thread.sleep(2000);
        driver.quit();*/

        /*System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        //隐式等待（只要元素找到就向下操作，没找到：：超时之后报异常）driver生命周期内都用到隐式等待，会有资源消耗
        //优点：灵活，不会浪费时间
        //缺点：不是所有的元素都需要等待；
        //      只能等待页面上存在的元素，（元素有但不可见，或者失效状态）

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("class-manage")).click();
        driver.findElement(By.partialLinkText("一周排课")).click();
        driver.quit();*/

        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/driver/chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");

        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("class-manage")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);


        //智能等待
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("一周排课")));
        driver.findElement(By.partialLinkText("一周排课")).click();
        //ExpectedConditions.numberOfElementsToBeLessThan(By.id("kw"), 5);

        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.partialLinkText("一周排课"));
            }
        });
        webElement.click();*/
        driver.switchTo().defaultContent();


        driver.quit();


        /*WebDriverWait wait1 = new WebDriverWait(driver, 10);
        Boolean isDisplayed = wait1.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.partialLinkText("一周排课")).isDisplayed();//是否显示
            }
        });*/

    }
}
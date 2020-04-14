package auto.test.register;

import auto.base.BaseCases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/9 0:39
 */
public class RegisterTest extends BaseCases {
    /*WebDriver driver = null;
    //初始化打开一个浏览器
    @BeforeClass
    public void beforeClass() {
        String browserName = "Chrome";
        String seleniumVersion = "3.X";
        driver = WebAutoUtils.getDriver(browserName, seleniumVersion);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        //执行用例完成后，关闭
        try {
            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*@DataProvider
    public static Object[][] getData() {
        Object[][] objects = new Object[][]{
                {"", "", "", "", "用户名不能为空"},
                {"abc", "", "", "", "非法的手机号"},
                {"13399990000", "", "", "", "密码不能为空"},
                {"13399990000", "12345", "12345", "", "密码长度至少为6位"},
                {"13399990000", "123456", "1234567", "", "密码不一致"},
                {"13399990000", "123456", "123456", "", "验证码不能为空"}
        };
        return objects;
    }*/

    @Test(dataProviderClass = RegisterDataProvider.class, dataProvider = "failCase")
    public void register_fail_case(String mobilephone, String password, String pwdconfirm, String verifycode, String exceptedTips) {
        to("register_url");
        send(By.id("mobilephone"), mobilephone);
        send(By.id("password"), password);
        send(By.id("pwdconfirm"), pwdconfirm);
        send(By.id("verifycode"), verifycode);
        click(By.xpath("//*[@id='signup-button']"));
        String actualTips = getTips(By.className("tips"));
        //driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        //driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        //driver.findElement(By.id("verifycode")).sendKeys(verifycode);
        //driver.findElement(By.xpath("//*[@id=\"signup-button\"]")).click();
        //String actualTips = driver.findElement(By.className("tips")).getText();
        System.out.println(actualTips);
        Assert.assertEquals(actualTips, exceptedTips);
    }
    //@Test(dataProviderClass = RegisterDataProvider.class, dataProvider = "failCase")
    public void test0409(String mobilephone, String password, String pwdconfirm, String verifycode, String exceptedTips) {
        to("register_url");
        send(By.id("mobilephone"), mobilephone);
        send(By.id("password"), password);
        send(By.id("pwdconfirm"), pwdconfirm);
        send(By.id("verifycode"), verifycode);
        click(By.xpath("//*[@id='signup-button']"));
        String actualTips = getTips(By.className("tips"));
        //driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        //driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        //driver.findElement(By.id("verifycode")).sendKeys(verifycode);
        //driver.findElement(By.xpath("//*[@id=\"signup-button\"]")).click();
        //String actualTips = driver.findElement(By.className("tips")).getText();
        System.out.println(actualTips);
        Assert.assertEquals(actualTips, exceptedTips);
    }

    //@Test
    public void test0408() {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"signup-button\"]")).click();
        String actualTips = driver.findElement(By.className("tips")).getText();
        //System.out.println(actualTips);
        String excepted = "用户名不能为空";
        //Assert.assertEquals(actualTips, excepted);
        driver.quit();
    }
}

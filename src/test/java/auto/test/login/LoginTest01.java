package auto.test.login;

import auto.base.BaseCases;
import auto.pojo.Locator;
import auto.pojo.LoginFailData;
import auto.pojo.LoginSuccessData;
import auto.utils.LocatorUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * 痛点：1.元素定位方式和值的维护比较麻烦---》分离
 *       2.api侵入：by
 * @author ZS
 * @Description:
 * @date 2020/4/8 23:59
 */
public class LoginTest01 extends BaseCases {


    @Test(dataProvider = "failCase", dataProviderClass = LoginDataProvider.class)
    public void login_fail_case(LoginFailData loginFailData) {
        to("login_url");
        /*send(By.id("mobilephone"), loginFailData.getPhone());
        send(By.id("password"), loginFailData.getPassword());
        click(By.id("login"));
        String actualTips = getTipsNotNull(By.className("tips"));*/

        //读取所有页面的元素定位信息
        Locator phoneLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","手机号");
        Locator pwdLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","密码");
        Locator loginLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","登录按钮");
        Locator tipsLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","提示Tips");

        /*Map<String, Map<String, Locator>> allPagesLocatorsMap = LocatorUtils.readXml();
        Locator phoneLocator = allPagesLocatorsMap.get("登录页面").get("手机号");
        Locator pwdLocator = allPagesLocatorsMap.get("登录页面").get("密码");
        Locator loginLocator = allPagesLocatorsMap.get("登录页面").get("登录按钮");
        Locator tipsLocator = allPagesLocatorsMap.get("登录页面").get("提示Tips");*/
        send(phoneLocator, loginFailData.getPhone());
        send(pwdLocator, loginFailData.getPassword());
        click(loginLocator);
        String actualTips = getTipsNotNull(tipsLocator);

        System.out.println(actualTips);
        Assert.assertEquals(actualTips, loginFailData.getExpectedTips());
    }

    @Test(dataProvider = "successData", dataProviderClass = LoginDataProvider.class)
    public void login_success_case(LoginSuccessData loginSuccessData) {
        to("login_url");
        send(By.id("mobilephone"), loginSuccessData.getPhone());
        send(By.id("password"), loginSuccessData.getPassword());
        click(By.id("login"));
        //        String currentPageUrl = getCurrentPageUrl();//1.需要硬性等待
        //        System.out.println(currentPageUrl);
        //        System.out.println(loginSuccessData.getPartialUrl());
        //        Assert.assertTrue(currentPageUrl.contains(loginSuccessData.getPartialUrl()));
        //2.智能等待
        Assert.assertTrue(currentPageUrlContains(loginSuccessData.getPartialUrl()));
    }

    /*public void test_fail(String mobilephone, String password, String exceptedTips) {
        to("login_url");
        send(By.id("mobilephone"), mobilephone);
        send(By.id("password"), password);
        click(By.id("login"));
        String actualTips = getTipsNotNull(By.className("tips"));
        System.out.println(actualTips);
        Assert.assertEquals(actualTips, exceptedTips);
    }*/

    /*@Test(dataProvider = "successData", dataProviderClass = LoginDataProvider.class)
    public void test_success(String mobilephone, String password, String exceptedUrl) {
        to("login_url");
        send(By.id("mobilephone"), mobilephone);
        send(By.id("password"), password);
        click(By.id("login"));
        String currentPageUrl = getCurrentPageUrl();
        System.out.println(currentPageUrl);
        System.out.println(exceptedUrl);
        Assert.assertTrue(currentPageUrl.contains(exceptedUrl));
    }*/




    /*@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "failCase")
    public void test0409(String mobilephone, String password, String exceptedTips) {
        to("login_url");
        send(By.id("mobilephone"), mobilephone);
        send(By.id("password"), password);
        click(By.id("login"));
        String actualTips = getTipsNotNull(By.className("tips"));
        //driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        //driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("login")).click();
        //String actualTips = driver.findElement(By.className("tips")).getText();
        System.out.println(actualTips);
        Assert.assertEquals(actualTips, exceptedTips);
    }*/

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
    public static void main(String[] args) throws InterruptedException {
        /*String browserName = "Chrome";
        String seleniumVersion = "3.X";
        WebDriver driver = WebAutoUtils.getDriver(browserName, seleniumVersion);
        Thread.sleep(2000);
        driver.quit();*/

    }

}

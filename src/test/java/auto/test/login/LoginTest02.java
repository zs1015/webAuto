package auto.test.login;

import auto.base.BaseCases;
import auto.pojo.LoginFailData;
import auto.pojo.LoginSuccessData;
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
public class LoginTest02 extends BaseCases {


    @Test(dataProvider = "failCase", dataProviderClass = LoginDataProvider.class)
    public void login_fail_case(LoginFailData loginFailData) {
        to("login_url");
        send("登录页面","手机号",loginFailData.getPhone());
        send("登录页面","密码",loginFailData.getPassword());
        click("登录页面","登录按钮");
        String actualTips = getTipsNotNull("登录页面","提示Tips");

        //读取所有页面的元素定位信息
        /*Locator phoneLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","手机号");
        Locator pwdLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","密码");
        Locator loginLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","登录按钮");
        Locator tipsLocator = LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面","提示Tips");
        send(phoneLocator, loginFailData.getPhone());
        send(pwdLocator, loginFailData.getPassword());
        click(loginLocator);
        String actualTips = getTipsNotNull(tipsLocator);*/
        System.out.println(actualTips);
        Assert.assertEquals(actualTips, loginFailData.getExpectedTips());
    }

    @Test(dataProvider = "successData", dataProviderClass = LoginDataProvider.class)
    public void login_success_case(LoginSuccessData loginSuccessData) {
        to("login_url");
        send(By.id("mobilephone"), loginSuccessData.getPhone());
        send(By.id("password"), loginSuccessData.getPassword());
        click(By.id("login"));
        //2.智能等待
        Assert.assertTrue(currentPageUrlContains(loginSuccessData.getPartialUrl()));
    }

    public static void main(String[] args) throws InterruptedException {
        /*String browserName = "Chrome";
        String seleniumVersion = "3.X";
        WebDriver driver = WebAutoUtils.getDriver(browserName, seleniumVersion);
        Thread.sleep(2000);
        driver.quit();*/

    }

}

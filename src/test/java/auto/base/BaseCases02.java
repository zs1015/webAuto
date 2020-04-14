package auto.base;

import auto.pojo.Locator;
import auto.utils.PropertiesUtils;
import auto.utils.WebAutoUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author ZS
 * @Description: 基础测试类
 * @date 2020/4/10 23:48
 */
public class BaseCases02 {
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
     * 打开页面url
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
        getElement(by).click();
    }

    /**
     * 输内容
     * @param by      By的元素定位器
     * @param content 内容
     */
    public void send(By by, String content) {
        getElement(by).sendKeys(content);
    }

    public void send(Locator locator, String content) {
        String type = locator.getType();
        String value = locator.getValue();
        By by = null;
        if ("id".equalsIgnoreCase(type)) {
            by = By.id(value);
        } else if ("name".equalsIgnoreCase(type)) {
            by = By.name(value);
        } else if ("tagName".equalsIgnoreCase(type)) {
            by = By.tagName(value);
        } else if ("linkText".equalsIgnoreCase(type)) {
            by = By.linkText(value);
        } else if ("partialLinkText".equalsIgnoreCase(type)) {
            by = By.partialLinkText(value);
        } else if ("cssSelector".equalsIgnoreCase(type)) {
            by = By.cssSelector(value);
        } else if ("className".equalsIgnoreCase(type)) {
            by = By.className(value);
        } else if ("xpath".equalsIgnoreCase(type)) {
            by = By.xpath(value);
        }
        getElement(by).sendKeys(content);
    }

    /**
     * 获取文本；
     * @param by By的元素定位器
     * @return
     */
    public String getTips(By by) {
        return getElement(by).getText();
    }

    /**
     * @param by
     * @return
     */
    public WebElement getElement(final By by) {
        return getElement(by, 5L);
    }

    /**
     * 统一的找元素方法
     * @param by            By的元素定位器
     * @param timeOutSecond 超时时间
     * @return
     */
    public WebElement getElement(final By by, Long timeOutSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public String getCurrentPageUrl() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }

    /**
     * 智能等待跳转的url::直到当前页面的url包含了partialUrl，才返回true
     * @param partialUrl
     * @return
     */
    public Boolean currentPageUrlContains(final String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.urlContains(partialUrl));
        /*Boolean b = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl != null && currentUrl.contains(partialUrl)) {
                    return true;
                }
                return false;
            }
        });
        return b;*/
    }

    /**
     * 等待元素文本不为空，长度大于0
     * @param by
     * @return
     */
    public String getTipsNotNull(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String text = wait.until(new ExpectedCondition<String>() {
            public String apply(WebDriver webDriver) {
                WebElement element = driver.findElement(by);//获取元素
                //元素不为空，文本不为空，且长度大于0
                if (element != null && element.getText() != null && element.getText().length() > 0) {
                    return element.getText();
                }
                return null;
            }
        });
        return text;
    }

    public WebElement getElementEnabled(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean isEnabled = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(by).isEnabled();
            }
        });
        return driver.findElement(by);
    }

    public WebElement getElementIsDisplayed(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean isEnabled = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(by).isDisplayed();
            }
        });
        return driver.findElement(by);
    }

    public WebElement getElementToBeClickable(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

}

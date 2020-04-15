package auto.test.register;

import org.testng.annotations.DataProvider;

/**
 * @author ZS
 * @Description:  0415日：遗弃
 * @date 2020/4/9 22:28
 */
public class RegisterDataProvider {

    @DataProvider
    public static Object[][] failCase() {//正向
        Object[][] objects = new Object[][]{
                {"", "", "", "", "用户名不能为空"},
                {"abc", "", "", "", "非法的手机号"},
                {"13399990000", "", "", "", "密码不能为空"},
                {"13399990000", "12345", "12345", "", "密码长度至少为6位"},
                {"13399990000", "123456", "1234567", "", "密码不一致"},
                {"13399990000", "123456", "123456", "", "验证码不能为空"}
        };
        return objects;
    }

    @DataProvider
    public static Object[][] successData() {//反向
        Object[][] objects = new Object[][]{
                {"", "", "", "", "用户名不能为空"},
                {"abc", "", "", "", "非法的手机号"},
                {"13399990000", "", "", "", "密码不能为空"},
                {"13399990000", "12345", "12345", "", "密码长度至少为6位"},
                {"13399990000", "123456", "1234567", "", "密码不一致"},
                {"13399990000", "123456", "123456", "", "验证码不能为空"}
        };
        return objects;
    }
}

package auto.test;

import auto.pojo.LoginFailData;
import auto.pojo.LoginSuccessData;
import auto.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/9 22:28
 */
public class LoginDataProvider01 {

    @DataProvider
    public static Object[][] failCase() {//反向

        ArrayList<Object> readExcelList = ExcelUtils.readExcel("/case/login.xlsx", 0, LoginFailData.class);
        //创建二维数组
        Object[][] datas = new Object[readExcelList.size()][];
        for (int i = 0; i < readExcelList.size(); i++) {
            LoginFailData loginFailData = (LoginFailData) readExcelList.get(i);
            Object[] itemArray = {loginFailData};
            datas[i] = itemArray;

        }

        /*Object[][] objects = new Object[][]{
                {"", "", "用户名不能为空"},
                {"abc", "", "非法的手机号"},
                {"13888886666", "", "密码不能为空"},
                {"13888886666", "123", "账号信息错误"}
        };*/
        return datas;
    }

    @DataProvider
    public static Object[][] successData() {//正向
        /*Object[][] objects = new Object[][]{
                {"13888888888", "123456", "index.html"},
        };
        return objects;*/
        ArrayList<Object> readExcelList = ExcelUtils.readExcel("/case/login.xlsx", 1, LoginSuccessData.class);
        //创建二维数组
        Object[][] datas = new Object[readExcelList.size()][];
        for (int i = 0; i < readExcelList.size(); i++) {
            LoginSuccessData loginSuccessData = (LoginSuccessData) readExcelList.get(i);
            Object[] itemArray = {loginSuccessData};
            datas[i] = itemArray;

        }

        /*Object[][] objects = new Object[][]{
                {"", "", "用户名不能为空"},
                {"abc", "", "非法的手机号"},
                {"13888886666", "", "密码不能为空"},
                {"13888886666", "123", "账号信息错误"}
        };*/
        return datas;
    }
}

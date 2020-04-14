package auto.test.login;

import auto.pojo.LoginFailData;
import auto.pojo.LoginSuccessData;
import auto.utils.DataProviderUtils;
import auto.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/9 22:28
 */
public class LoginDataProvider {

    @DataProvider
    public static Object[][] failCase(Method method) {//反向
        System.out.println("---反向-----");
        System.out.println(method.getName());
        return DataProviderUtils.getData("/case/login.xlsx", 0, LoginFailData.class);

        /*ArrayList<Object> readExcelList = ExcelUtils.readExcel("/case/login.xlsx", 0, LoginFailData.class);
        //创建二维数组
        Object[][] datas = new Object[readExcelList.size()][];
        for (int i = 0; i < readExcelList.size(); i++) {
            LoginFailData loginFailData = (LoginFailData) readExcelList.get(i);
            Object[] itemArray = {loginFailData};
            datas[i] = itemArray;

        }
        return datas;*/
    }

    @DataProvider
    public static Object[][] successData(Method method) {//正向
        System.out.println("----正向----");
        System.out.println(method.getName());
        return DataProviderUtils.getData("/case/login.xlsx", 1, LoginSuccessData.class);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //测试用例的方法名：method.getName()
        //通过方法名，获取excel路径，及类名
        String st = "login_fail_case";
        String[] array = st.split("_");
        String folderName = array[0];
        //String classPath = "com.auto.test.login.LoginTest";
        //Class clazz = Class.forName(classPath);

        String excelName = array[1];
        //String excelPath = "case/login/fail.xlsx";
        String excelPath = "case/"+folderName+"/"+excelName+".xlsx";
        System.out.println(excelPath);
        //ArrayList<Object> readExcelList = ExcelUtils.readExcel(excelPath, 0, clazz);

    }
}

package auto.base;

import auto.pojo.LoginFailData;
import auto.pojo.LoginSuccessData;
import auto.utils.DataProviderUtils;
import auto.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author ZS
 * @Description: 所有测试用例的数据提供者
 * @date 2020/4/15 01:28
 */
public class CaseDataProvider {

    @DataProvider
    public static Object[][] getAllCaseData(Method method) {
        String methodName = method.getName();
        String[] array = methodName.split("_");
        //得到模块名、功能名、类名的第一部分login
        String folderName = array[0];
        //检查点名、类名的第二部分：fail
        String caseFileName = array[1];
        //获得类名
        //String className1 = "auto.pojo.LoginFailData";
        String className1 = (folderName.charAt(0) + "").toUpperCase() + folderName.substring(1);
        String className2 = (caseFileName.charAt(0) + "").toUpperCase() + caseFileName.substring(1);
        String totalClassName = className1 + className2 + "Data";
        String classPath = "auto.pojo." + totalClassName;
        Class clazz = null;
        try {
            clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String excelPath = "/case/" + folderName + "/" + caseFileName + ".xlsx";
        ArrayList<Object> readExcelList = ExcelUtils.readExcel(excelPath, 0, clazz);
        //创建二维数组
        Object[][] datas = new Object[readExcelList.size()][];
        for (int i = 0; i < readExcelList.size(); i++) {
            Object[] itemArray = {readExcelList.get(i)};
            datas[i] = itemArray;
        }
        return datas;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //测试用例的方法名：method.getName()
        //通过方法名，获取excel路径，及类名
        /**login_fail_case
         * login:数据+元素
         * fail：  login_fail 数据
         * 类名：LoginFailData
         *       LoginSuccessData
         */
        String methodName = "login_success_case";
        String[] array = methodName.split("_");
        //得到模块名、功能名、类名的第一部分login
        String folderName = array[0];
        //检查点名、类名的第二部分：fail
        String caseFileName = array[1];
        //获得类名
        //String className1 = "auto.pojo.LoginFailData";
        String className1 = (folderName.charAt(0) + "").toUpperCase() + folderName.substring(1);
        String className2 = (caseFileName.charAt(0) + "").toUpperCase() + caseFileName.substring(1);
        String totalClassName = className1 + className2 + "Data";
        String classPath = "auto.pojo." + totalClassName;
        Class clazz = Class.forName(classPath);
        String excelPath = "/case/" + folderName + "/" + caseFileName + ".xlsx";
        ArrayList<Object> readExcelList = ExcelUtils.readExcel(excelPath, 0, clazz);
        for (Object o : readExcelList) {
            System.out.println(o);
        }
    }
}

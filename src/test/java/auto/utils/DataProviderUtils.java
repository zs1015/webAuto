package auto.utils;

import auto.pojo.BaseExcel;

import java.util.ArrayList;

/**
 * @author ZS
 * @Description:  分开数据提供的方法：0415日遗弃
 * @date 2020/4/13 22:30
 */
public class DataProviderUtils {
    /**
     * 获取Excel的数据
     * @param excelPath
     * @param sheetIndex
     * @param clazz
     * @return
     */
    public static Object[][] getData(String excelPath, int sheetIndex, Class<? extends BaseExcel> clazz) {
        ArrayList<Object> readExcelList = ExcelUtils.readExcel(excelPath, sheetIndex, clazz);
        //创建二维数组
        Object[][] datas = new Object[readExcelList.size()][];
        for (int i = 0; i < readExcelList.size(); i++) {
            Object[] itemArray = {readExcelList.get(i)};
            datas[i] = itemArray;
        }
        /*for (int i = 0; i < readExcelList.size(); i++) {
            Object object = readExcelList.get(i);
            Object[] itemArray = {readExcelList.get(i)};
            datas[i] = itemArray;

        }*/
        return datas;
    }
}

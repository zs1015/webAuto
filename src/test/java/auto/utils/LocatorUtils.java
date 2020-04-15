package auto.utils;

import auto.pojo.Locator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/14 00:59
 * <p>
 * 怎样找到登录页面的按钮？1.找到登录页面---找出登录按钮
 * Map<String, Locator>,保存一个页面的所有定位方式
 * Map<String ,Map<String, Locator>>保存所有页面的所有定位方式
 */
public class LocatorUtils {
    private static Map<String, Map<String, Locator>> allPagesLocatorsMap = new HashMap<String, Map<String, Locator>>();

    public static Map<String, Locator> getPageLocatorsByPageName(String pageName) {
        return allPagesLocatorsMap.get(pageName);
    }

    public static Locator getLocatorByPageNameAndLocatorName(String pageName, String locatorName) {
        return getPageLocatorsByPageName(pageName).get(locatorName);
    }


    //只加载Xml文件一次
    static {
        //获得page的路径，去获取page下的xml
        String pagePath = LocatorUtils.class.getClassLoader().getResource("page").getPath();
        readFoldersXmlFile(pagePath);
        //allPagesLocatorsMap = readXml();
    }

    private static Map<String, Map<String, Locator>> readXml(String xmlFilePath) {
        SAXReader saxReader = new SAXReader();
        //InputStream inputStream = null;
        //inputStream = LocatorUtils.class.getResourceAsStream("/page/login/page.xml");
        InputStream inputStream = null;
        // 读取xml文件
        Document document = null;
        try {
            inputStream = new FileInputStream(xmlFilePath);//把xml文件加载成io流
            document = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 读取元素
        Element rootElement = document.getRootElement();
        ////准备容器，保存所有页面的定位信息locator
        //List<Element> list = rootElement.elements("page");
        //System.out.println(list);
        //Map<String, Map<String, Locator>> allPagesLocatorsMap = new HashMap<String, Map<String, Locator>>();
        //for (Element element : list) {
        String pageName = rootElement.attributeValue("pageName");
        List<Element> locatorElements = rootElement.elements();
        //准备容器，保存当前页面的定位信息locator
        Map<String, Locator> currentLocatorMap = new HashMap<String, Locator>();
        for (Element locatorElement : locatorElements) {
            String name = locatorElement.attributeValue("name");
            String type = locatorElement.attributeValue("type");
            String value = locatorElement.attributeValue("value");
            Locator locator = new Locator(name, type, value);
            currentLocatorMap.put(name, locator);
        }
        allPagesLocatorsMap.put(pageName, currentLocatorMap);
        return allPagesLocatorsMap;
    }

    /**
     * 获取文件夹中的所有xml文件  递归
     * @param folderName
     */
    public static void readFoldersXmlFile(String folderName) {
        File file = new File(folderName);
        // 列出这个文件夹的所有的子文件
        File[] subFiles = file.listFiles();
        for (File subFile : subFiles) {
            // 子文件的完整的路径
            String subFilePath = subFile.getAbsolutePath();
            // 如果是xml文件，直接进行解析
            if (subFile.isFile() && subFilePath.endsWith(".xml")) {
                readXml(subFilePath);
            } else {
                // 是目录文件，继续遍历--》我需要一个功能:现在有一个文件夹路径，要获取到其中的xml文件
                readFoldersXmlFile(subFilePath);// 递归调用
            }
        }
    }
    //多个页面，在一个xml文件时可以用此方法
    /*private static Map<String, Map<String, Locator>> readXml() {
        SAXReader saxReader = new SAXReader();
        // 读取xml文件
        Document document = null;
        try {
            document = saxReader.read(LocatorUtils.class.getResourceAsStream("/page/login/page.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 读取元素
        Element rootElement = document.getRootElement();
        ////准备容器，保存所有页面的定位信息locator
        List<Element> list = rootElement.elements("page");
        System.out.println(list);
        Map<String, Map<String, Locator>> allPagesLocatorsMap = new HashMap<String, Map<String, Locator>>();
        for (Element element : list) {
            String pageName = element.attributeValue("pageName");
            List<Element> locatorElements = element.elements();
            //准备容器，保存当前页面的定位信息locator
            Map<String, Locator> currentLocatorMap = new HashMap<String, Locator>();
            for (Element locatorElement : locatorElements) {
                String name = locatorElement.attributeValue("name");
                String type = locatorElement.attributeValue("type");
                String value = locatorElement.attributeValue("value");
                Locator locator = new Locator(name, type, value);
                //System.out.println(locator);
                currentLocatorMap.put(name, locator);
            }
            allPagesLocatorsMap.put(pageName, currentLocatorMap);
        }
        return allPagesLocatorsMap;
    }*/

    public static void main(String[] args) {
        //Map<String, Map<String, Locator>> allPagesLocatorsMap = readXml();
        //Locator locator = allPagesLocatorsMap.get("登录页面").get("登录按钮");
        //System.out.println(locator);
    }

}
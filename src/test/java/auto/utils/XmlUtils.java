package auto.utils;

import auto.pojo.Locator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.xml.XmlTest;

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
public class XmlUtils {
    public static void main(String[] args) {
        Map<String, Map<String, Locator>> allPagesLocatorsMap = readXml();
        Locator locator = allPagesLocatorsMap.get("登录页面").get("登录按钮");
        System.out.println(locator);
    }

    public static Map<String, Map<String, Locator>> readXml() {
        SAXReader saxReader = new SAXReader();
        // 读取xml文件
        Document document = null;
        try {
            document = saxReader.read(XmlTest.class.getResourceAsStream("/page/page.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 读取元素
        Element rootElement = document.getRootElement();
        ////准备容器，保存所有页面的定位信息locator
        List<Element> list = rootElement.elements("page");
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
    }

}
package auto.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author ZS
 * @Description: 页面的单个元素定位locator
 * @date 2020/4/14 1:02
 */
@Data
@ToString
public class Locator {
    private String name;
    private String type;
    private String value;

    public Locator(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }
}

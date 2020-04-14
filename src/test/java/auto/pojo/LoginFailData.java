package auto.pojo;

import lombok.Data;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/13 21:41
 */

@Data
public class LoginFailData extends BaseExcel {
    private String phone;
    private String password;
    private String expectedTips;

    @Override
    public String toString() {
        return "LoginData{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", expectedTips='" + expectedTips + '\'' +
                '}';
    }
}

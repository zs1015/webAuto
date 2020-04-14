package auto.pojo;

import lombok.Data;

/**
 * @author ZS
 * @Description:
 * @date 2020/4/13 22:21
 */

@Data
public class LoginSuccessData extends BaseExcel {
    private String phone;
    private String password;
    private String partialUrl;

    @Override
    public String toString() {
        return "LoginData{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", partialUrl='" + partialUrl + '\'' +
                '}';
    }
}

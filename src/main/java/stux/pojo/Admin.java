package stux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员实体类
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer id;         // 管理员id
    private String username;    // 用户名
    private String password;    // 密码

}

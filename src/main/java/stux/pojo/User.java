
package stux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author HEX9CF
 * @date 2023/02/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer gender;
    private LocalDate birthday;
    private String school;
    private String major;
    private Integer entryYear;
    private String location;
    private String hometown;
    private String signature;
    private Integer ban;
    private Integer article;
    private Integer comment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

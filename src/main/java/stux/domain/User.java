
package stux.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author HEX9CF
 * @date 2023/02/24
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String passwd;
    private String email;
    private String phone;
    private String sex;
    private Integer birthyear;
    private Integer birthmonth;
    private Integer birthday;
    private String school;
    private String major;
    private String grade;
    private String location;
    private String hometown;
    private String signature;
    private Integer ban;
    private Integer article;
    private Integer comment;
    private String regtime;
}

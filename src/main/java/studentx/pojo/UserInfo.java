package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 用户信息实体类
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer id;            // ID
    private Integer userId;         // 用户ID
    private Integer gender;         // 性别
    private LocalDate birthday;     // 生日
    private String school;          // 学校
    private String major;           // 专业
    private Integer entryYear;      // 入学年份
    private String location;        // 所在地
    private String hometown;        // 家乡
    private String signature;       // 个性签名
}

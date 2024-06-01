package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 朋友关系实体类
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {
    private Integer id;         // ID
    private Integer userId;    // 用户ID
    private Integer friendId;    // 朋友ID
    private Integer status;     // 状态：0 陌生人，1 请求添加 ，2 好友，3 拉黑
    private String relationship;    // 关系
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
}

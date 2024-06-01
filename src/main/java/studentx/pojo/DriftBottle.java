package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 漂流瓶实体类
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriftBottle {
    private Integer id;     // ID
    private Integer userId;    // 用户ID
    private Integer pickerId;    // 拾取者ID
    private String message;     // 信息
    private Integer status;     // 状态：0 草稿，1 已扔出，2 被拾取
    private LocalDateTime createTime;     // 发布时间
    private LocalDateTime updateTime;     // 更新时间
}

package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论实体类
 *
 * @author HEX9CF
 * @date 2023/09/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;         // ID
    private Integer userId;     // 用户ID
    private Integer postId;     // 帖子ID
    private String content;     // 内容
    private Integer ban;        // 封禁状态
}

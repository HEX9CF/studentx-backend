package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论计数实体类
 *
 * @author HEX9CF
 * @date 2023/09/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCnt {
    private Integer id;         // ID
    private Integer likeCnt;    // 点赞数
}

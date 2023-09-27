package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户计数
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCnt {
    private Integer postCnt;   // 发帖数
    private Integer likeCnt;      // 点赞数
    private Integer comomentCnt;  // 评论数
}

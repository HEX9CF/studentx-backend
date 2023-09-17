package stux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章计数实体类
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCnt {
    private Integer readCnt;        // 阅读数
    private Integer likeCnt;        // 点赞数
    private Integer commentCnt;     // 评论数
}

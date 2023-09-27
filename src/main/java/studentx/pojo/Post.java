package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 文章实体类
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;         // 文章id
    private Integer blockId;    // 板块id
    private String title;       // 标题
    private Integer authorId;   // 作者id
    private String content;     // 正文
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
    private Integer ban;        // 封禁状态
}

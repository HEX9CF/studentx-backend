package stux.pojo;

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
public class Article {
    private Integer id;
    private Integer blockId;
    private String title;
    private Integer authorId;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer viewed;
    private Integer liked;
    private Integer commented;
    private Integer ban;
}

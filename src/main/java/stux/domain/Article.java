package stux.domain;

import lombok.Data;

/**
 * 文章实体类
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Data
public class Article {
    private Integer id;
    private Integer block;
    private String title;
    private String author;
    private String content;
    private String crtime;
    private String uptime;
    private Integer viewed;
    private Integer liked;
    private Integer remark;
    private Integer ban;
}

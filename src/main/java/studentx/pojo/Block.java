package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 板块实体类
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    private Integer id;             // 板块id
    private String name;            // 名称
    private String description;     // 简介
}

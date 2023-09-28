package studentx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

/**
 * 系统设置实体类
 *
 * @author HEX9CF
 * @date 2023/09/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Setting {
    private Integer id;         // ID
    private String key;         // 键
    private String val;         // 值
    private String description; // 描述
}

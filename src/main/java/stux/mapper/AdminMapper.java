package stux.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import stux.pojo.Admin;

/**
 * 管理员映射
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}

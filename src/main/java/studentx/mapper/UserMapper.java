package studentx.mapper;

import studentx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户映射器
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

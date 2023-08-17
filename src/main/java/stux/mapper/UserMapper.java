package stux.mapper;

import stux.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据访问对象
 *
 * @author HEX9CF
 * @date 2023/02/24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

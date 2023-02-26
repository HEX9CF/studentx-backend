package stux.dao;

import stux.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户DAO
 *
 * @author HEX9CF
 * @date 2023/02/24
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

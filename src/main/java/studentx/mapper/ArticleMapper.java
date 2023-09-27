package studentx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import studentx.pojo.Post;

/**
 * 文章映射器
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Post> {
}

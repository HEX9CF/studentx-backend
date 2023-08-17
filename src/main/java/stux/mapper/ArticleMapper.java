package stux.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import stux.pojo.Article;

/**
 * 文章数据访问对象
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}

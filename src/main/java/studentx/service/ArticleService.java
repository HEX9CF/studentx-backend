package studentx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import studentx.pojo.Article;

/**
 * 文章服务层接口
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
public interface ArticleService extends IService<Article> {
    boolean save(Article article);
    boolean modify(Article article);
    boolean delete(Integer id);
    IPage<Article> getPage(int currentPage, int pageSize);
    IPage<Article> getPage(int currentPage, int pageSize, Article article);
}


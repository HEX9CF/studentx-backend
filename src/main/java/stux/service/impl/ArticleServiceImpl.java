package stux.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stux.dao.ArticleDao;
import stux.domain.Article;
import stux.service.ArticleService;

/**
 * 文章服务实现类
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * 保存
     *
     * @param article 文章
     * @return boolean
     */
    @Override
    public boolean save(Article article) {
        return articleDao.insert(article) > 0;
    }

    /**
     * 修改
     *
     * @param article 文章
     * @return boolean
     */
    @Override
    public boolean modify(Article article) {
        return articleDao.updateById(article) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return articleDao.deleteById(id) > 0;
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Article}>
     */
    @Override
    public IPage<Article> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        articleDao.selectPage(page, null);
        return page;
    }

    /**
     * 按条件获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param article     文章
     * @return {@link IPage}<{@link Article}>
     */
    @Override
    public IPage<Article> getPage(int currentPage, int pageSize, Article article) {
        LambdaQueryWrapper<Article> lqw = new LambdaQueryWrapper<Article>();
        lqw.like(Strings.isNotEmpty(article.getTitle()), Article::getTitle, article.getTitle());
        lqw.like(article.getBlock() != 0, Article::getBlock, article.getBlock());
        IPage page = new Page(currentPage, pageSize);
        articleDao.selectPage(page, lqw);
        return page;
    }
}

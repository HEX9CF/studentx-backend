package studentx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentx.mapper.ArticleMapper;
import studentx.pojo.Post;
import studentx.service.ArticleService;

/**
 * 文章服务实现类
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Post> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 保存
     *
     * @param post 文章
     * @return boolean
     */
    @Override
    public boolean add(Post post) {
        return articleMapper.insert(post) > 0;
    }

    /**
     * 修改
     *
     * @param post 文章
     * @return boolean
     */
    @Override
    public boolean modify(Post post) {
        return articleMapper.updateById(post) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return articleMapper.deleteById(id) > 0;
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Post}>
     */
    @Override
    public IPage<Post> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        articleMapper.selectPage(page, null);
        return page;
    }

    /**
     * 按条件获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param post     文章
     * @return {@link IPage}<{@link Post}>
     */
    @Override
    public IPage<Post> getPage(int currentPage, int pageSize, Post post) {
        LambdaQueryWrapper<Post> lqw = new LambdaQueryWrapper<Post>();
        lqw.like(Strings.isNotEmpty(post.getTitle()), Post::getTitle, post.getTitle());
        IPage page = new Page(currentPage, pageSize);
        articleMapper.selectPage(page, lqw);
        return page;
    }
}

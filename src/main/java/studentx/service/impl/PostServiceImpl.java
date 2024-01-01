package studentx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentx.mapper.PostMapper;
import studentx.pojo.Post;
import studentx.service.PostService;

import java.time.LocalDateTime;

/**
 * 文章服务实现类
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Slf4j
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    private PostMapper postMapper;

    /**
     * 保存
     *
     * @param post 文章
     * @return boolean
     */
    @Override
    public boolean add(Post post) {
        LocalDateTime time = LocalDateTime.now();
        post.setCreateTime(time);
        post.setUpdateTime(time);
        return postMapper.insert(post) > 0;
    }

    /**
     * 修改
     *
     * @param post 文章
     * @return boolean
     */
    @Override
    public boolean modify(Post post) {
        LocalDateTime time = LocalDateTime.now();
        post.setUpdateTime(time);
        return postMapper.updateById(post) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return postMapper.deleteById(id) > 0;
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
        postMapper.selectPage(page, null);
        return page;
    }

    /**
     * 倒序获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Post}>
     */
    @Override
    public IPage<Post> getPageDesc(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        postMapper.selectPage(page, queryWrapper);
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
    public IPage<Post> getPageDesc(int currentPage, int pageSize, Post post) {
        LambdaQueryWrapper<Post> lqw = new LambdaQueryWrapper<Post>();
        lqw.like(Strings.isNotEmpty(post.getTitle()), Post::getTitle, post.getTitle());
        IPage page = new Page(currentPage, pageSize);
        postMapper.selectPage(page, lqw);
        return page;
    }
}

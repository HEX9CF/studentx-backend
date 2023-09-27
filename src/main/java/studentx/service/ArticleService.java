package studentx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import studentx.pojo.Post;

/**
 * 文章服务层接口
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
public interface ArticleService extends IService<Post> {
    boolean add(Post post);
    boolean modify(Post post);
    boolean delete(Integer id);
    IPage<Post> getPage(int currentPage, int pageSize);
    IPage<Post> getPage(int currentPage, int pageSize, Post post);
}


package stux.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stux.controller.util.R;
import stux.domain.Article;
import stux.service.ArticleService;

/**
 * 文章控制器
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * 获取全部
     *
     * @return {@link R}
     */
    @GetMapping
    public R getAll() {
        return new R(true, articleService.list());
    }

    /**
     * 修改
     *
     * @param article 文章
     * @return {@link R}
     */
    @PostMapping
    public R modify(@RequestBody Article article) {
        boolean flag = articleService.modify(article);
        return new R(flag, flag ? "修改成功" : "修改失败");
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link R}
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = articleService.delete(id);
        return new R(flag, flag ? "删除成功" : "删除失败");
    }

    /**
     * 通过id
     *
     * @param id id
     * @return {@link R}
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, articleService.getById(id));
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param article     文章
     * @return {@link R}
     */
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, int pageSize, Article article) {
        IPage<Article> page = articleService.getPage(currentPage, pageSize, article);
        if(currentPage > page.getPages()){
            page = articleService.getPage((int)page.getPages(), pageSize, article);
        }
        return new R(null != page, page);
    }
}

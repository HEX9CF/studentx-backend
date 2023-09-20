package studentx.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.Result;
import studentx.pojo.Article;
import studentx.service.ArticleService;

/**
 * 管理文章控制器
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * 获取全部
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result getAll() {
        return Result.success(articleService.list());
    }

    /**
     * 修改
     *
     * @param article 文章
     * @return {@link Result}
     */
    @PostMapping
    public Result modify(@RequestBody Article article) {
        boolean flag = articleService.modify(article);
        if(flag) {
            return new Result(1, "修改成功", null);
        }
        return new Result(0, "修改失败", null);
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link Result}
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = articleService.delete(id);
        if(flag) {
            return new Result(1, "删除成功", null);
        }
        return new Result(0, "删除失败", null);
    }

    /**
     * 通过id
     *
     * @param id id
     * @return {@link Result}
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(articleService.getById(id));
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param article     文章
     * @return {@link Result}
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, int pageSize, Article article) {
        IPage<Article> page = articleService.getPage(currentPage, pageSize, article);
        if(currentPage > page.getPages()){
            page = articleService.getPage((int)page.getPages(), pageSize, article);
        }
        if(null != page) {
            return Result.success(page);
        }
        return Result.error();
    }
}

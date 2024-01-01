package studentx.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.Result;
import studentx.pojo.Post;
import studentx.service.PostService;

/**
 * 管理文章控制器
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@RestController
@RequestMapping("/api/admin/post")
public class AdminPostController {
    @Autowired
    PostService postService;

    /**
     * 获取全部
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result getAll() {
        return Result.success(postService.list());
    }

    /**
     * 修改
     *
     * @param post 文章
     * @return {@link Result}
     */
    @PostMapping
    public Result modify(@RequestBody Post post) {
        boolean flag = postService.modify(post);
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
        boolean flag = postService.delete(id);
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
        return Result.success(postService.getById(id));
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param post     文章
     * @return {@link Result}
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Post post) {
        IPage<Post> page = postService.getPageDesc(currentPage, pageSize, post);
        if(currentPage > page.getPages()){
            page = postService.getPageDesc((int)page.getPages(), pageSize, post);
        }
        if(null != page) {
            return Result.success(page);
        }
        return Result.error();
    }
}

package studentx.controller.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.Post;
import studentx.pojo.Result;
import studentx.pojo.User;
import studentx.service.PostService;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 文章控制器
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;

    /**
     * 获取全部
     *
     * @return {@link Result}
     */
    /*
    @GetMapping
    public Result getAll() {
        return Result.success(postService.list());
    }
    */

    /**
     * 降序获取页面
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result getPageDesc() {
        return Result.success(postService.getPageDesc(1, 100).getRecords());
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return {@link Result}
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(postService.getById(id));
    }

    /**
     * 保存
     *
     * @param post
     * @return {@link Result}
     * @throws IOException
     */
    @PostMapping
    public Result save(@RequestBody Post post) throws IOException {
        log.info("帖子发布：{}", post);

        // 验证必填项
        if(post.getTitle().isEmpty()) {
            return Result.error("发布失败，标题不能为空", null);
        }
        if(post.getContent().isEmpty()) {
            return Result.error("发布失败，内容不能为空", null);
        }

        Post postNew = new Post();
        postNew.setTitle(post.getTitle());
        postNew.setContent(post.getContent());
        postNew.setAuthorId(post.getAuthorId());
        postNew.setBlockId(post.getBlockId());
        postNew.setBan(0);

        boolean flag = postService.add(post);
        if(flag) {
            return new Result(1, "发布成功", null);
        }
        return new Result(0, "发布失败", null);
    }
}

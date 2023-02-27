package stux.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stux.controller.util.R;
import stux.domain.User;
import stux.service.UserService;
import java.io.IOException;

/**
 * 用户控制器
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取全部
     *
     * @return {@link R}
     */
    @GetMapping
    public R getAll(){
        return new R(true, userService.list());
    }

    /**
     * 保存
     *
     * @param user
     * @return {@link R}
     * @throws IOException
     */
    @PostMapping
    public R save(@RequestBody User user) throws IOException {
        boolean flag = userService.save(user);
        return new R(flag, flag ? "注册成功" : "注册失败");
    }

    /**
     * 修改
     *
     * @param user
     * @return {@link R}
     */
    @PutMapping
    public R modify(@RequestBody User user) {
        boolean flag = userService.modify(user);
        return new R(flag, flag ? "修改成功" : "修改失败");
    }

    /**
     * 删除
     *
     * @param id
     * @return {@link R}
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return new R(flag, flag ? "删除成功" : "数据同步失败");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return {@link R}
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, userService.getById(id));
    }

    /**
     * 分页
     *
     * @param currentPage
     * @param pageSize
     * @param user
     * @return {@link R}
     */
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, User user){
        IPage<User> page = userService.getPage(currentPage, pageSize, user);
        if(currentPage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize, user);
        }
        return new R(null != page, page);
    }
}

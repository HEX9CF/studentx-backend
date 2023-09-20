package studentx.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.Result;
import studentx.pojo.User;
import studentx.service.UserService;
import java.io.IOException;

/**
 * 管理用户控制器
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;

    /**
     * 获取全部
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result getAll(){
        return Result.success(userService.list());
    }

    /**
     * 保存
     *
     * @param user
     * @return {@link Result}
     * @throws IOException
     */
    @PostMapping
    public Result save(@RequestBody User user) throws IOException {
        boolean flag = userService.save(user);
        if(flag) {
            return new Result(1, "注册成功", null);
        }
        return new Result(0, "注册失败", null);
    }

    /**
     * 修改
     *
     * @param user
     * @return {@link Result}
     */
    @PutMapping
    public Result modify(@RequestBody User user) {
        boolean flag = userService.modify(user);
        if(flag) {
            return new Result(1, "修改成功", null);
        }
        return new Result(0, "修改失败", null);
    }

    /**
     * 删除
     *
     * @param id
     * @return {@link Result}
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        if(flag) {
            return new Result(1, "删除成功", null);
        }
        return new Result(0, "删除失败", null);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return {@link Result}
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    /**
     * 分页
     *
     * @param currentPage
     * @param pageSize
     * @param user
     * @return {@link Result}
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, User user){
        IPage<User> page = userService.getPage(currentPage, pageSize, user);
        if(currentPage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize, user);
        }
        if(null != page) {
            return Result.success(page);
        }
        return Result.error();
    }
}

package stux.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stux.pojo.Result;
import stux.pojo.User;
import stux.service.UserService;
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
        return new Result(true, userService.list());
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
        return new Result(flag, flag ? "注册成功" : "注册失败");
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
        return new Result(flag, flag ? "修改成功" : "修改失败");
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
        return new Result(flag, flag ? "删除成功" : "数据同步失败");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return {@link Result}
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, userService.getById(id));
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
        return new Result(null != page, page);
    }
}

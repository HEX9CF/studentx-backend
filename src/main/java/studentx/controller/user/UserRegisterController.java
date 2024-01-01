package studentx.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentx.pojo.Result;
import studentx.pojo.User;
import studentx.service.UserService;

import java.time.LocalDateTime;

/**
 * 用户注册控制器
 *
 * @author HEX9CF
 * @date 2023/09/21
 */
@Slf4j
@RestController
@RequestMapping("/api/user/register")
public class UserRegisterController {
    @Autowired
    UserService userService;

    @PostMapping
    public Result register(@RequestBody User user) {
        log.info("用户注册：{}", user);

        // 验证必填项
        if(user.getUsername().isEmpty()) {
            return Result.error("注册失败，用户名不能为空", null);
        }
        if(user.getPassword().isEmpty()) {
            return Result.error("注册失败，密码不能为空", null);
        }

        // 验证是否重复注册
        User userCheck = userService.getByUsername(user.getUsername());
        if(userCheck != null) {
            return Result.error("注册失败，用户名重复", null);
        }

        User userNew = new User();
        userNew.setUsername(user.getUsername());
        userNew.setPassword(user.getUsername());
        userNew.setEmail(user.getEmail());
        userNew.setPhone(user.getPhone());
        userNew.setAdmin(0);
        userNew.setBan(0);

        // 验证通过，进行注册
        userService.add(user);
        return Result.success("注册成功，请返回登录页面登录", null);
    }
}

package studentx.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentx.pojo.User;
import studentx.service.UserService;
import studentx.utils.JwtUtils;
import studentx.pojo.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员登录控制器
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/login")
public class AdminLoginController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登录
     *
     * @param user 使用者
     * @return {@link Result}
     */
    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("管理员登录：{}", user);

        // 验证必填项
        if(user.getUsername().isEmpty()) {
            return Result.error("登录失败，用户名不能为空", null);
        }
        if(user.getPassword().isEmpty()) {
            return Result.error("登录失败，密码不能为空", null);
        }

        // 登录校验
        user = userService.login(user);
        if(user == null) {
            return Result.error("登录失败，用户名或密码错误", null);
        }
        if(user.getBan().equals(1)) {
            return Result.error("登录失败，账号被封禁，请联系管理员", null);
        }
        if(user.getAdmin().equals(0)) {
            return Result.error("登录失败，权限不足", null);
        }

        // 校验通过，发放令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("admin", user.getAdmin());
        String jwt = jwtUtils.generateJwt(claims);
        return Result.success("登录成功", jwt);
    }
}

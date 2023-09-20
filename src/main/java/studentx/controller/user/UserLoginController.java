package studentx.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentx.service.UserService;
import studentx.utils.JwtUtils;

/**
 * 用户登录控制器
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@RestController
@RequestMapping("/user/login")
public class UserLoginController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;
}

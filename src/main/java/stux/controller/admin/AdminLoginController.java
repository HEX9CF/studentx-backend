package stux.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stux.pojo.Admin;
import stux.service.AdminService;
import stux.utils.JwtUtils;
import stux.pojo.Result;

/**
 * 管理员登录控制器
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Slf4j
@RestController
@RequestMapping("/admin/login")
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping
    public Result login(@RequestBody Admin admin) {
        log.info("管理员登录：{}", admin);
        Boolean login = adminService.login(admin);
        if(login) {

        }
        return new Result();
    }
}

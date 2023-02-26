package stux.service;

import stux.domain.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stux.service.UserService;

/**
 * 用户服务层测试用例
 *
 * @author HEX9CF
 * @date 2023/02/26
 */
@SpringBootTest
public class UserServiceTestCase {
    @Autowired
    private UserService userService;

    /**
     * 测试通过id查询
     */
    @Test
    void testGetById() {
        System.out.println(userService.getById(5));
    }

    /**
     * 测试保存
     */
    @Test
    void testSave() {
        User user = new User();
        user.setName("测试用户");
        user.setSex("男");
        user.setPasswd("qweryuiop");
        user.setEmail("test@example.com");
        user.setPhone("12312345678");
        userService.save(user);
    }

    /**
     * 测试更新
     */
    @Test
    void testUpdate() {
        User user = new User();
        user.setId(5);
        user.setName("测试用户");
        user.setSex("女");
        user.setPasswd("qweryuiop");
        user.setEmail("test@example.com");
        user.setPhone("12312345678");
        userService.updateById(user);
    }

    /**
     * 测试删除
     */
    @Test
    void testDelete() {
        userService.removeById(6);
    }

    /**
     * 测试得到全部
     */
    @Test
    void testGetAll() {
        userService.list();
    }

    /**
     * 测试分页
     */
    @Test
    void testGetPage() {
        IPage<User> page = new Page<User>(2, 5);
        userService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}

package cn.stux.dao;

import cn.stux.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户DAO测试用例
 *
 * @author HEX9CF
 * @date 2023/02/24
 */
@SpringBootTest
public class UserDaoTestCase {
    @Autowired
    private UserDao userDao;

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
        userDao.insert(user);
    }

    /**
     * 测试通过id查询
     */
    @Test
    void testGetById() {
        System.out.println(userDao.selectById(1));
    }

    /**
     * 测试获取全部
     */
    @Test
    void testGetAll() {
        System.out.println(userDao.selectList(null));
    }

    /**
     * 测试更新
     */
    @Test
    void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("测试用户");
        user.setSex("女");
        user.setPasswd("qweryuiop");
        user.setEmail("test@example.com");
        user.setPhone("12312345678");
        userDao.updateById(user);
    }

    /**
     * 测试删除
     */
    @Test
    void testDelete(){
        userDao.deleteById(4);
    }

    /**
     * 测试分页
     */
    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        userDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    /**
     * 测试条件查询
     */
    @Test
    void testGetByCondiction1() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("name", "admin");
        userDao.selectList(qw);
    }

    /**
     * 测试条件查询2
     */
    @Test
    void testGetByCondiction2() {
//        String name = "admin";
        String name = null;
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name), User::getName, name);
        userDao.selectList(lqw);
    }
}

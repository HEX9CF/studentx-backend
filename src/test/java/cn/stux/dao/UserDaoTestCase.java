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

@SpringBootTest
public class UserDaoTestCase {
    @Autowired
    private UserDao userDao;
    @Test
    void testSave() {
        // 保存数据
        User user = new User();
        user.setName("测试用户");
        user.setSex("男");
        user.setPasswd("qweryuiop");
        user.setEmail("test@example.com");
        user.setPhone("12312345678");
        userDao.insert(user);
    }
    @Test
    void testGetById() {
        // 按id查询
        System.out.println(userDao.selectById(1));
    }
    @Test
    void testGetAll() {
        // 读取全部
        System.out.println(userDao.selectList(null));
    }
    @Test
    void testUpdate() {
        // 更新数据
        User user = new User();
        user.setId(3);
        user.setName("测试用户");
        user.setSex("女");
        user.setPasswd("qweryuiop");
        user.setEmail("test@example.com");
        user.setPhone("12312345678");
        userDao.updateById(user);
    }
    @Test
    void testDelete(){
        userDao.deleteById(4);
    }
    @Test
    void testGetPage() {
        // 分页测试
        IPage page = new Page(2, 5);
        userDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
    @Test
    void testGetByCondiction1() {
        // 条件查询
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("name", "admin");
        userDao.selectList(qw);
    }
    @Test
    void testGetByCondiction2() {
        // 条件查询
//        String name = "admin";
        String name = null;
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name), User::getName, name);
        userDao.selectList(lqw);
    }
}

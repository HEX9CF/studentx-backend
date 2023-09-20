package studentx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import studentx.mapper.UserMapper;
import studentx.pojo.User;
import studentx.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现类
 *
 * @author HEX9CF
 * @date 2023/02/26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 保存
     *
     * @param user 用户
     * @return boolean
     */
    @Override
    public boolean save(User user){
        return userMapper.insert(user) > 0;
    }

    /**
     * 修改
     *
     * @param user 用户
     * @return boolean
     */
    @Override
    public boolean modify(User user){
        return userMapper.updateById(user) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    /**
     * 登录
     *
     * @param user 使用者
     * @return boolean
     */
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        queryWrapper.allEq(map);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 分页功能
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link User}>
     */
    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, null);
        return page;
    }

    /**
     * 按条件查询
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param user        用户
     * @return {@link IPage}<{@link User}>
     */
    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.like(Strings.isNotEmpty(user.getUsername()), User::getUsername, user.getUsername());
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, lqw);
        return page;
    }
}

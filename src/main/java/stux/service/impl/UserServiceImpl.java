package stux.service.impl;

import stux.mapper.UserMapper;
import stux.pojo.User;
import stux.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

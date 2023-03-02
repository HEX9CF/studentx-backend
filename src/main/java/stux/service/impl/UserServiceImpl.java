package stux.service.impl;

import stux.dao.UserDao;
import stux.domain.User;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 保存
     *
     * @param user 用户
     * @return boolean
     */
    @Override
    public boolean save(User user){
        return userDao.insert(user) > 0;
    }

    /**
     * 修改
     *
     * @param user 用户
     * @return boolean
     */
    @Override
    public boolean modify(User user){
        return userDao.updateById(user) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
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
        userDao.selectPage(page, null);
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
        lqw.like(Strings.isNotEmpty(user.getUname()), User::getUname, user.getUname());
        IPage page = new Page(currentPage, pageSize);
        userDao.selectPage(page, lqw);
        return page;
    }
}

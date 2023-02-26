package cn.stux.service;

import cn.stux.domain.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户服务层接口
 *
 * @author HEX9CF
 * @date 2023/02/26
 */
public interface UserService extends IService<User> {
    boolean save(User user);
    boolean modify(User user);
    boolean delete(Integer id);
    IPage<User> getPage(int currentPage, int pageSize);
    IPage<User> getPage(int currentPage, int pageSize, User user);
}
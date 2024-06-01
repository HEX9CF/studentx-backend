package studentx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentx.mapper.FriendshipMapper;
import studentx.pojo.Friendship;
import studentx.service.FriendshipService;

import java.time.LocalDateTime;

/**
 * 友谊服务impl
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Slf4j
@Service
public class FriendshipServiceImpl extends ServiceImpl<FriendshipMapper, Friendship> implements FriendshipService {
    @Autowired
    private FriendshipMapper friendshipMapper;

    /**
     * 添加
     *
     * @param friendship 友谊
     * @return boolean
     */
    @Override
    public boolean add(Friendship friendship) {
        LocalDateTime time = LocalDateTime.now();
        friendship.setCreateTime(time);
        friendship.setUpdateTime(time);
        return friendshipMapper.insert(friendship) > 0;
    }

    /**
     * 修改
     *
     * @param friendship 友谊
     * @return boolean
     */
    @Override
    public boolean modify(Friendship friendship) {
        friendship.setUpdateTime(LocalDateTime.now());
        return friendshipMapper.updateById(friendship) > 0;
    }

    /**
     * 删去
     *
     * @param friendship 友谊
     * @return boolean
     */
    @Override
    public boolean delete(Friendship friendship) {
        QueryWrapper<Friendship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", friendship.getUserId());
        queryWrapper.eq("friend_id", friendship.getFriendId());
        return friendshipMapper.delete(queryWrapper) > 0;
    }

    /**
     * 查询
     *
     * @param userId   用户id
     * @param friendId 好友id
     * @return {@link Friendship }
     */
    @Override
    public Friendship get(Integer userId, Integer friendId) {
        QueryWrapper<Friendship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("friend_id", friendId);
        return friendshipMapper.selectOne(queryWrapper);
    }

    /**
     * 获取状态
     *
     * @param userId   用户id
     * @param friendId 好友id
     * @return boolean
     */
    @Override
    public Integer getStatus(Integer userId, Integer friendId) {
        QueryWrapper<Friendship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("friend_id", friendId);
        Friendship friendship = friendshipMapper.selectOne(queryWrapper);
        return (friendship == null) ? 0 : friendship.getStatus();
    }

    /**
     * 按用户id获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param userId      用户id
     * @return {@link IPage }<{@link Friendship }>
     */
    @Override
    public IPage<Friendship> getPageByUserId(int currentPage, int pageSize, Integer userId) {
        IPage<Friendship> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Friendship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        friendshipMapper.selectPage(page, queryWrapper);
        return page;
    }
}

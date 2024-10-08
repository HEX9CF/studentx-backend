package studentx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import studentx.pojo.Friendship;

/**
 * 友谊服务
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
public interface FriendshipService extends IService<Friendship> {
    boolean add(Friendship friendship);
    boolean modify(Friendship friendship);
    boolean deleteByUserIdAndFriendId(Integer userId, Integer friendId);
    Friendship get(Integer userId, Integer friendId);
    Integer getStatus(Integer userId, Integer friendId);
    IPage<Friendship> getPageByUserIdAndStatus(int currentPage, int pageSize, Integer userId, Integer status);
}

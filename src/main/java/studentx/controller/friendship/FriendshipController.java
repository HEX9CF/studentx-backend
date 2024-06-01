package studentx.controller.friendship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.Friendship;
import studentx.pojo.Result;
import studentx.service.FriendshipService;

/**
 * 朋友关系控制器
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Slf4j
@RestController
@RequestMapping("/api/friendship")
public class FriendshipController {
    @Autowired
    FriendshipService friendshipService;

    /**
     * 获取状态
     *
     * @param userId   用户id
     * @param friendId 好友id
     * @return {@link Result }
     */
    @GetMapping("{userId}/{friendId}")
    public Result getStatus(@PathVariable Integer userId, @PathVariable Integer friendId) {
        log.info("查询好友关系：{} {}", userId, friendId);

        Integer status = friendshipService.getStatus(userId, friendId);
        return Result.success(status);
    }

    /**
     * 请求好友
     *
     * @param friendship 友谊
     * @return {@link Result }
     */
    @PostMapping
    public Result request(@RequestBody Friendship friendship) {
        log.info("请求添加好友：{}", friendship);

        // 验证必填项
        if(friendship.getUserId() == null) {
            return Result.error("请求失败，用户id不能为空", null);
        }
        if(friendship.getFriendId() == null) {
            return Result.error("请求失败，好友id不能为空", null);
        }
        if(friendship.getUserId().equals(friendship.getFriendId())) {
            return Result.error("请求失败，不能添加自己为好友", null);
        }

        // 验证是否重复请求
       Integer status = friendshipService.getStatus(friendship.getUserId(), friendship.getFriendId());
        switch (status) {
            case 1:
                return Result.error("请求失败，已经发送过请求", null);
            case 2:
                return Result.error("请求失败，已经是好友", null);
            case 3:
                return Result.error("请求失败，已经被拉黑", null);
        }

        // 验证通过，添加好友请求
        Friendship newFriendship = new Friendship();
        newFriendship.setUserId(friendship.getFriendId());
        newFriendship.setFriendId(friendship.getUserId());
        newFriendship.setStatus(1);
        friendshipService.add(newFriendship);
        return Result.success("请求成功，请等待对方同意", null);
    }

    /**
     * 接受朋友
     *
     * @param friendship 友谊
     * @return {@link Result }
     */
    @PutMapping
    public Result accept(@RequestBody Friendship friendship) {
        log.info("接受好友请求：{}", friendship);

        // 验证必填项
        if(friendship.getUserId() == null) {
            return Result.error("接受失败，用户id不能为空", null);
        }
        if(friendship.getFriendId() == null) {
            return Result.error("接受失败，好友id不能为空", null);
        }

        // 验证是否存在好友请求
        Integer status = friendshipService.getStatus(friendship.getUserId(), friendship.getFriendId());
        switch(status) {
            case 0:
                return Result.error("接受失败，不存在好友请求", null);
            case 2:
                return Result.error("接受失败，已经是好友", null);
            case 3:
                return Result.error("接受失败，已经拉黑此用户", null);
        }

        // 验证通过，接受好友请求
        Friendship newFriendship = friendshipService.get(friendship.getUserId(), friendship.getFriendId());
        newFriendship.setStatus(2);
        friendshipService.modify(newFriendship);
        return Result.success("接受成功", null);
    }


    /**
     * 解除好友关系
     *
     * @param friendship 友谊
     * @return {@link Result }
     */
    @DeleteMapping
    public Result unfriend(@RequestBody Friendship friendship) {
        log.info("解除好友：{}", friendship);

        // 验证必填项
        if(friendship.getUserId() == null) {
            return Result.error("解除失败，用户id不能为空", null);
        }
        if(friendship.getFriendId() == null) {
            return Result.error("解除失败，好友id不能为空", null);
        }

        // 验证是否存在好友关系
        Integer status = friendshipService.getStatus(friendship.getUserId(), friendship.getFriendId());
        if(status != 2) {
            return Result.error("解除失败，不存在好友关系", null);
        }

        // 验证通过，解除好友关系
        friendshipService.delete(friendship);
        return Result.success("解除成功", null);
    }
}

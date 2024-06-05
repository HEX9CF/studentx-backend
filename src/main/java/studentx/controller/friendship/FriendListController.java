package studentx.controller.friendship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentx.pojo.Result;
import studentx.service.FriendshipService;

/**
 * 好友列表控制器
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Slf4j
@RestController
@RequestMapping("/api/friendList")
public class FriendListController {
    @Autowired
    FriendshipService friendshipService;

    @GetMapping("{id}/{status}")
    public Result getFriendList(@PathVariable Integer id, @PathVariable Integer status) {
        return Result.success(friendshipService.getPageByUserIdAndStatus(1, 100, id, status).getRecords());
    }
}

package studentx.controller.friendship;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentx.pojo.Friendship;
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
@RequestMapping("/api/friendship/list")
public class FriendListController {
    @Autowired
    FriendshipService friendshipService;

    @GetMapping("{id}/{currentPage}/{pageSize}")
    public Result getFriendList(@PathVariable Integer id, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<Friendship> page = friendshipService.getPageByUserId(currentPage, pageSize, id);
        if(currentPage > page.getPages()){
            page = friendshipService.getPageByUserId((int)page.getPages(), pageSize, id);
        }
        if(null != page) {
            return Result.success(page);
        }
        return Result.error();
    }
}

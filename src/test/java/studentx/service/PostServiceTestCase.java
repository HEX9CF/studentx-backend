package studentx.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 服务条测试用例
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@SpringBootTest
public class PostServiceTestCase {
    @Autowired
    private PostService postService;
    @Test
    void testGetByAll() {
        postService.list();
    }
}

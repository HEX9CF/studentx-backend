package stux.service;

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
public class ArticleServiceTestCase {
    @Autowired
    private ArticleService articleService;
    @Test
    void testGetByAll() {
        articleService.list();
    }
}

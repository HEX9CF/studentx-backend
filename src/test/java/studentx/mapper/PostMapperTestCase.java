package studentx.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 文章数据访问对象测试用例
 *
 * @author HEX9CF
 * @date 2023/03/02
 */
@SpringBootTest
public class PostMapperTestCase {
    @Autowired
    private PostMapper postMapper;
    @Test
    void testGetAll() {
        postMapper.selectList(null);
    }
}

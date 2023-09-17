package stux.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jwt属性
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String signKey;     // 签名密钥
    private Long expiration;    // 有效期
}

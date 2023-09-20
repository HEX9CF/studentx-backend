package studentx.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studentx.props.JwtProperties;

import java.util.Date;
import java.util.Map;

/**
 * JWT Utils
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Component
public class JwtUtils {
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 生成jwt
     *
     * @param claims 索赔
     * @return {@link String}
     */
    public String generateJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSignKey())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .compact();
        return jwt;
    }

    /**
     * 解析jwt
     *
     * @param jwt jwt
     * @return {@link Claims}
     */
    public Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtProperties.getSignKey())
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}

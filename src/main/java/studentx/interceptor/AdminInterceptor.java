package studentx.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import studentx.pojo.Result;
import studentx.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员拦截器
 *
 * @author HEX9CF
 * @date 2023/09/20
 */
@Slf4j
@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtils jwtUtils;

    /**
     * 预处理
     *
     * @param request  要求
     * @param response 回答
     * @param handler  处理程序
     * @return boolean
     * @throws Exception 例外
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求URL
        String url = request.getRequestURL().toString();
        log.info("请求URL：{}", url);

        // 获取请求头令牌
        String jwt = request.getHeader("token");
        log.info("请求头令牌：{}", jwt);

        // 令牌不存在
        if(!StringUtils.hasLength(jwt)) {
            log.info("令牌不存在，拦截请求");
            Result result = Result.error("NOT_LOGIN", null);
            String json = JSONObject.toJSONString(result);
            response.getWriter().write(json);
            return false;
        }

        // 解析令牌
        Claims claims;
        try {
            claims = jwtUtils.parseJwt(jwt);
        } catch(Exception e) {
            e.printStackTrace();
            log.info("令牌无法解析，拦截请求");
            Result result = Result.error("NOT_LOGIN", null);
            String json = JSONObject.toJSONString(result);
            response.getWriter().write(json);
            return false;
        }

        // 验证管理员权限
        if(claims.get("admin", Integer.class).equals(0)) {
                log.info("无管理员权限，拦截请求");
            Result result = Result.error("NOT_LOGIN", null);
            String json = JSONObject.toJSONString(result);
            response.getWriter().write(json);
            return false;
        }

        // 校验通过，放行
        return true;
    }
}

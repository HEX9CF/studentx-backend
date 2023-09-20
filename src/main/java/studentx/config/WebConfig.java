package studentx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import studentx.interceptor.AdminInterceptor;

/**
 * web配置
 *
 * @author HEX9CF
 * @date 2023/09/20
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册管理员拦截器
        registry.addInterceptor(adminInterceptor)
                // 拦截管理面板
                .addPathPatterns("/admin/**")
                // 放行登录操作
                .excludePathPatterns("/admin/login");

    }
}

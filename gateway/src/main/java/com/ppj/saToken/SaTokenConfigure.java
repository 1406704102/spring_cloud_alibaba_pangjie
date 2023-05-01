package com.ppj.saToken;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类 
 * @author kong
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器 
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
            // 拦截地址 
            .addInclude("/**")    /* 拦截全部path */
            // 开放地址 
            .addExclude("/favicon.ico")
            // 鉴权方法：每次访问进入 
            .setAuth(obj -> {
                // 登录校验 -- 拦截所有路由，并排除xxx 用于开放登录
                SaRouter.match("/**")    // 拦截的 path 列表，可以写多个 */
                        .notMatch("/api/auth_route/**")        // 排除掉的 path 列表，可以写多个
                        .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
                // 权限认证 -- 不同模块, 校验不同权限 
//                SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
//                SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
//                SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
//                SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));
                
                // 更多匹配 ...  */
            })
            // 异常处理方法：每次setAuth函数出现异常时进入 
            .setError(e -> SaResult.error(e.getMessage()))
            ;
    }
}

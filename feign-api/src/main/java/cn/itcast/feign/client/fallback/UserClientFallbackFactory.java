package cn.itcast.feign.client.fallback;

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return id -> {
            // 记录异常信息
            log.error("查询用户异常", throwable);
            // 返回默认数据
            return new User();
        };
    }
}

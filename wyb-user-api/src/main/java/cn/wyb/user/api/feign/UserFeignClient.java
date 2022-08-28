package cn.wyb.user.api.feign;

import cn.wyb.user.api.dto.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 */
@FeignClient(name = "wyb-user",
        url = "${wybuser.wyb-user.url:127.0.0.1:8080}",
        fallbackFactory = UserFeignClient.UserFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/get/{userId}")
    @ResponseBody
    User getUserById(@PathVariable Long userId);

    @Component
    class UserFallbackFactory implements FallbackFactory<UserFeignClient> {

        @Override
        public UserFeignClient create(Throwable cause) {
            return userId -> null;
        }
    }
}

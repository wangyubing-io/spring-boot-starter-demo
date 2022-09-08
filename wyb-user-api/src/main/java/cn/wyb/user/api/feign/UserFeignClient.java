package cn.wyb.user.api.feign;

import cn.wyb.user.api.common.Response;
import cn.wyb.user.api.dto.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 */
@FeignClient(name = "wyb-user",
        url = "${wybuser.wyb-user.url:127.0.0.1:8080}",
        fallbackFactory = UserFeignClient.UserFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/{userId}")
    @ResponseBody
    @PatchMapping
    Response<User> getUserById(@PathVariable Long userId);

    @DeleteMapping("/{userId}")
    @ResponseBody
    Response<Object> deleteUserById(@PathVariable Long userId);

    @PutMapping("/add")
    @ResponseBody
    Response<User> add(@RequestBody User user);

    @PostMapping("/update")
    @ResponseBody
    Response<User> update(@RequestBody User user);

    @Component
    class UserFallbackFactory implements FallbackFactory<UserFeignClient> {

        @Override
        public UserFeignClient create(Throwable cause) {
            return new UserFeignClient() {
                @Override
                public Response<User> getUserById(Long userId) {
                    return Response.<User>builder().build();
                }

                @Override
                public Response<Object> deleteUserById(Long userId) {
                    return Response.builder().build();
                }

                @Override
                public Response<User> add(User user) {
                    return Response.<User>builder().build();
                }

                @Override
                public Response<User> update(User user) {
                    return Response.<User>builder().build();
                }
            };
        }
    }
}

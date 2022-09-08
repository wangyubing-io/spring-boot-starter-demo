package cn.wyb.user.web.controllers;

import cn.wyb.user.api.common.Response;
import cn.wyb.user.api.dto.User;
import cn.wyb.user.api.feign.UserFeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@RestController
public class UserController implements UserFeignClient {

    private static final Map<Long, User> users = new HashMap<>();

    static {
        users.put(1000L, new User(1000L, "haha1000"));
        users.put(1001L, new User(1001L, "haha1001"));
        users.put(1002L, new User(1002L, "haha1002"));
        users.put(1003L, new User(1003L, "haha1003"));
        users.put(1004L, new User(1004L, "haha1004"));
        users.put(1005L, new User(1005L, "haha1005"));
    }


    @Override
    @GetMapping("/{userId}")
    public Response<User> getUserById(@PathVariable("userId") Long userId) {
        return Response.<User>builder().code(0).msg("success").data(users.get(userId)).build();
    }

    @Override
    @DeleteMapping("/{userId}")
    public Response<Object> deleteUserById(Long userId) {
        return Response.builder().code(0).msg("success").data(users.remove(userId)).build();
    }

    @Override
    @PutMapping("/add")
    public Response<User> add(@RequestBody User user) {
        users.put(user.getId(),new User(user.getId(),user.getName()));
        return Response.<User>builder().code(0).msg("success").data(users.get(user.getId())).build();
    }

    @Override
    @PostMapping("/update")
    public Response<User> update(@RequestBody User user) {
        users.put(user.getId(),new User(user.getId(),user.getName()));
        return Response.<User>builder().code(0).msg("success").data(users.get(user.getId())).build();
    }
}

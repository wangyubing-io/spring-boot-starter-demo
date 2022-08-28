package cn.wyb.user.test.controllers;

import cn.wyb.user.api.dto.User;
import cn.wyb.user.api.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        User userById = userFeignClient.getUserById(userId);
        if (userById == null) {
            return new User(1L, "haha");
        }
        return userById;
    }
}

package cn.wyb.user.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
//@EnableFeignClients(basePackageClasses = UserFeignClient.class)
public class WybUserTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WybUserTestApplication.class, args);
    }

}

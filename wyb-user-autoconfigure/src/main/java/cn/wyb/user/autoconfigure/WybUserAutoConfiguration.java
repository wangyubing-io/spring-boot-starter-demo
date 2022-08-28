package cn.wyb.user.autoconfigure;

import cn.wyb.user.api.feign.UserFeignClient;
import cn.wyb.user.api.feign.UserFeignMarker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author admin
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(UserFeignMarker.class)
@EnableFeignClients(basePackageClasses = UserFeignMarker.class)
@EnableConfigurationProperties(WybUserConfiguration.class)
@Import({UserFeignClient.UserFallbackFactory.class})
public class WybUserAutoConfiguration {
}

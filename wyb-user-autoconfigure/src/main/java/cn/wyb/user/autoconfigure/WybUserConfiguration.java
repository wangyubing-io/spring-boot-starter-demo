package cn.wyb.user.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "wybuser.wyb-user")
@Data
public class WybUserConfiguration {

    private String url = "127.0.0.1:8080";
}

package std.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月17日
 * @desc NacosConfigMain3377
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigMain3377
{
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain3377.class, args);
    }
}

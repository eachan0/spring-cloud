package std.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc OrderZkMain80
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderCsMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderCsMain80.class,args);
    }
}

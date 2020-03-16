package std.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月16日
 * @desc StreamProviderMain8801
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderMain8801.class, args);
    }
}

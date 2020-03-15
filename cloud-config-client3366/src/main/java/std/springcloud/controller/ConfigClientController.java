package std.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月15日
 * @desc ConfigClientController
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * curl -X POST http://localhost:3366/actuator/refresh  刷新配置
     */
    @Value("${config.info}")
    private String info;

    @GetMapping("info")
    public String configInfo(){
        return info;
    }
}

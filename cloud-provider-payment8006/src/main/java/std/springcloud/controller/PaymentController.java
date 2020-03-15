package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc PaymentController 支付控制器
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("zk")
    public String getById() {
        return "Spring cloud with zookeeper at port:" + port + "\t" + UUID.randomUUID().toString();
    }
}

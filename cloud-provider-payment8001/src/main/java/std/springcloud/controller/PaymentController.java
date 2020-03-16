package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;
import std.springcloud.service.PaymentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult<String> create(@RequestBody Payment payment) {
        int result = service.create(payment);
        if (result > 0) {
            return new CommonResult<>(200, "创建成功");
        } else {
            return new CommonResult<>(500, "创建失败");
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getById(@PathVariable Integer id) {
        return new CommonResult<>(200, "from port:" + port, service.getPaymentById(id));
    }

    @GetMapping("about")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(log::error);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(x -> log.error(x.getInstanceId() + x.getHost() + x.getPort() + x.getUri()));
        return discoveryClient;
    }

    @GetMapping("lb")
    public String lb(){
        return port;
    }

    @GetMapping("timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时测试";
    }

    @GetMapping("zipkin")
    public String zipkin() {
        return "zipkin 测试";
    }
}

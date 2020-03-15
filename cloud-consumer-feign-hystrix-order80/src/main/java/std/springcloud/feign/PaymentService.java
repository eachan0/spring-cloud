package std.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import std.springcloud.feign.impl.PaymentServiceImpl;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc PaymentService
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("payment/ok")
     String paymentOk();


    @GetMapping("payment/timeout")
    String paymentTimeout();
}

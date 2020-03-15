package std.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc PaymentService
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Integer id);

    @GetMapping("payment/timeout")
    String timeout();
}

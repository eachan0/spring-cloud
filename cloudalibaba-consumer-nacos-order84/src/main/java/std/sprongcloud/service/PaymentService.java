package std.sprongcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;
import std.sprongcloud.service.impl.PaymentFallbackServiceImpl;


/**
 * @author zhuyc
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Long id);

}

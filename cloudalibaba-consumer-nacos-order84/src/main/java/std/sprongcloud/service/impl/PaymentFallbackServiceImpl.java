package std.sprongcloud.service.impl;

import org.springframework.stereotype.Component;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;
import std.sprongcloud.service.PaymentService;

/**
 * @author zhuyc
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}

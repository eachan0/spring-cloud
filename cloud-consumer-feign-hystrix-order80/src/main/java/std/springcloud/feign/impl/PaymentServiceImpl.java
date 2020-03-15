package std.springcloud.feign.impl;

import org.springframework.stereotype.Component;
import std.springcloud.feign.PaymentService;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月15日
 * @desc PaymentServiceImpl
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentOk() {

        return "payment ok fallback";
    }

    @Override
    public String paymentTimeout() {
        return "paymentTimeout fallback";
    }
}

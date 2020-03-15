package std.springcloud.service;

import std.springcloud.entities.Payment;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc PaymentService 支付
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Integer id);
}

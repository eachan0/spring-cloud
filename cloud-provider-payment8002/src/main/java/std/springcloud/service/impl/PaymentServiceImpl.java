package std.springcloud.service.impl;

import org.springframework.stereotype.Service;
import std.springcloud.entities.Payment;
import std.springcloud.service.PaymentService;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc PaymentServiceImpl
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public int create(Payment payment) {
        System.out.println(payment.toString());
        return 1;
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return new Payment(Long.valueOf(id),"202003140106");
    }
}

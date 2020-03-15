package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.service.PaymentSerivce;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月15日
 * @desc PaymentController
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentSerivce paymentSerivce;

    @GetMapping("ok")
    public String paymentOk() {
        String paymentOk = paymentSerivce.paymentOk();
        System.out.println(paymentOk);
        return paymentOk;
    }

    @GetMapping("timeout")
    public String paymentTimeout() {
        String paymentTimeout = paymentSerivce.paymentTimeout();
        System.out.println(paymentTimeout);
        return paymentTimeout;
    }

    @GetMapping("circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id){
        String s = paymentSerivce.paymentCircuitBreaker(id);
        System.out.println(s);
        return s;
    }
}

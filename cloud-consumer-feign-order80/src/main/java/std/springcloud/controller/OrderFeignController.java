package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;
import std.springcloud.feign.PaymentService;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc OrderFeignController
 */
@RestController
@Slf4j
@RequestMapping("consumer/payment")
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @GetMapping("timeout")
    public String timeout(){
        return paymentService.timeout();
    }
}

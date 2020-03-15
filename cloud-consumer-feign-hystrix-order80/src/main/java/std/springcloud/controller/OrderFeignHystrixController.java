package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
//@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderFeignHystrixController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("ok")
    public String paymentOk() {
        String paymentOk = paymentService.paymentOk();
        System.out.println(paymentOk);
        return paymentOk;
    }

    @GetMapping("timeout")
//    @HystrixCommand
    /*@HystrixCommand(fallbackMethod = "paymentTimeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    public String paymentTimeout() {
        String paymentTimeout = paymentService.paymentTimeout();
        System.out.println(paymentTimeout);
        return paymentTimeout;
    }
    public String paymentTimeoutHandle() {
        return "线程池: " + Thread.currentThread().getName() + "80系统繁忙,稍后再试\t" + "/(ㄒoㄒ)/~~";
    }

    public String paymentGlobalFallback(){
        return "Global fallback";
    }
}

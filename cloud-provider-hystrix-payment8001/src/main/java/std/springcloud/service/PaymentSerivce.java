package std.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月15日
 * @desc PaymentSerivce
 */
@Service
public class PaymentSerivce {

    //--服务降级

    public String paymentOk() {
        return "线程池: " + Thread.currentThread().getName() + "ok\t" + "O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentTimeout() {
//        int i=10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "timeout\t" + "O(∩_∩)O";
    }

    public String paymentTimeoutHandle() {
        return "线程池: " + Thread.currentThread().getName() + "8001系统繁忙,稍后再试\t" + "/(ㄒoㄒ)/~~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandle",commandProperties  ={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("id 不能为负数");
        }
        String serial = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 流水号: " + serial;
    }

    public String paymentCircuitBreakerHandle(Integer id){
        return "id: "+ id + " must > 0";
    }
}

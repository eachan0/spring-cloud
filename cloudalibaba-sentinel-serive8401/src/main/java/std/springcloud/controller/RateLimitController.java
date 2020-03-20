package std.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;
import std.springcloud.handler.CustomerBlockHandler;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月20日
 * @desc RateLimitController
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源限定名称限流测试OK", new Payment(1L, "1110"));
    }
    public CommonResult<String> handleException(BlockException ex) {
        return new CommonResult<>(444, "按资源限定名称限流测试OK", ex.getClass().getCanonicalName());
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按 URL 限流测试 OK", new Payment(2L, "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "customerBlockHandler2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按照用户自定义", new Payment(2020L, "serial0003"));
    }
}

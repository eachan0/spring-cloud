package std.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import std.springcloud.entities.CommonResult;
import std.springcloud.entities.Payment;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月20日
 * @desc CustomerBlockHandler
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> customerBlockHandler(BlockException ex) {
        return new CommonResult<>(4444, "按照用户自定义, global handlerException-------1",
                new Payment(2020L, "serial0003"));
    }
    public static CommonResult<Payment> customerBlockHandler2(BlockException ex) {
        return new CommonResult<>(4444, "按照用户自定义, global handlerException----2",
                new Payment(2020L, "serial0003"));
    }
}

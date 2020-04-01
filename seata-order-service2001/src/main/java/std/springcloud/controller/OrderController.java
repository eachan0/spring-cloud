package std.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.domain.CommonResult;
import std.springcloud.domain.Order;
import std.springcloud.service.OrderService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zhuyc
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult<Object> create() {
        Order order = new Order();
        order.setProductId(1L);
        order.setCount(2);
        order.setMoney(BigDecimal.valueOf(20));
        order.setUserId(1L);
        order.setStatus(0);
        orderService.create(order);
        return new CommonResult<>(200,"订单创建成功");
    }
}

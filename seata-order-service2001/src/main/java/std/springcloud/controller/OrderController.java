package std.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.domain.CommonResult;
import std.springcloud.domain.Order;
import std.springcloud.service.OrderService;

import javax.annotation.Resource;

/**
 * @author zhuyc
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult<Object> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200,"订单创建成功");
    }
}

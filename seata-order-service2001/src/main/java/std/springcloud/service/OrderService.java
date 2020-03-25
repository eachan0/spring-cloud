package std.springcloud.service;

import std.springcloud.domain.Order;

/**
 * @author zhuyc
 */
public interface OrderService {
    /**
     * 创建
     * @param order :
     */
    void create(Order order);
}

package std.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import std.springcloud.domain.Order;

/**
 * @author zhuyc
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order :
     */
    void create(Order order);

    /**
     * 修改订单状态，从零改为1
     * @param userId :
     * @param status :
     */
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}

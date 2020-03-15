package std.springcloud.lb.impl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import std.springcloud.lb.LoadBalanced;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc LoadBalancedImpl
 */
@Component
public class LoadBalancedImpl implements LoadBalanced {

    /**
     * 初始值
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自旋锁 和 CAS 获取访问次数
     *
     * @return next
     */
    private int incrementAndGetIndex() {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = current >= 10000 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                System.out.println("****访问次数---- " + next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = incrementAndGetIndex() % instances.size();
        return instances.get(index);
    }
}

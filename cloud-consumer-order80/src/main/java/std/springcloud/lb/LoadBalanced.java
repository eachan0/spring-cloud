package std.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月14日
 * @desc LoadBalanced
 */
public interface LoadBalanced {
    /**
     * 获取下一个实例
     *
     * @param instances 总实例集合
     * @return 轮询到的实例
     */
    ServiceInstance instances(List<ServiceInstance> instances);
}

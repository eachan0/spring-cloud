package std.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月15日
 * @desc GatewayLogFilter
 */
@Component
@Slf4j
public class GatewayLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***开始处理请求,尝试获取用户名");
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (StringUtils.isBlank(name)){
            log.error("***处理请求完成,未获取到用户名,程序结束");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.error("***处理请求完成,获取到用户名,程序继续运行");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

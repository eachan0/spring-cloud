package std.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import std.springcloud.domain.CommonResult;

import java.math.BigDecimal;

/**
 * @author zhuyc
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 扣钱
     * @param userId:
     * @param money :
     * @return CommonResult
     */
    @PostMapping(value = "/account/decrease")
    CommonResult<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}

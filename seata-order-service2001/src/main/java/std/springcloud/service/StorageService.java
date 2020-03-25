package std.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import std.springcloud.domain.CommonResult;


/**
 * @author zhuyc
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣库存
     * @param productId :
     * @param count :
     * @return CommonResult
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult<Object> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

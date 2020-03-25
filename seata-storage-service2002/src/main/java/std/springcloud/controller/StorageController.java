package std.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.domain.CommonResult;
import std.springcloud.service.StorageService;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult<Object> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200,"扣减库存成功！");
    }
}

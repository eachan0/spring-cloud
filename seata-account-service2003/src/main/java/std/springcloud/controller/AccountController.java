package std.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.domain.CommonResult;
import std.springcloud.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zhuyc
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult<>(200,"扣减账户余额成功！");
    }
}

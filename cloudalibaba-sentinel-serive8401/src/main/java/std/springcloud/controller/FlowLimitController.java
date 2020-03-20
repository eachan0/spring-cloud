package std.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月20日
 * @desc FlowLimitController
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        return "----- testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println("test b");
        return "----- testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        // test RT
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("test d");
        // test 异常比例和异常数
        int i = 10 / 0;
        return "----- test d";
    }

    @GetMapping("hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "hotKeyHandle")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2) {
        return "hot key ok";
    }

    public String hotKeyHandle(String p1, String p2, BlockException e) {
        return "hot key error";
    }
}

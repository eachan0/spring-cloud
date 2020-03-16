package std.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.springcloud.service.MessageProvider;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月16日
 * @desc StreamController
 */
@RestController
@Slf4j
@RequestMapping("stream")
public class StreamController {

    @Autowired
    private MessageProvider provider;

    @GetMapping("send")
    public String send(){
        return provider.send();
    }
}

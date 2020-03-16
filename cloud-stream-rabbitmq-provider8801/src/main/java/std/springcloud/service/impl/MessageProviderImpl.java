package std.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import std.springcloud.service.MessageProvider;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年03月16日
 * @desc MessageProviderImpl
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String uid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(uid).build());
        System.out.println("serial uid: " + uid);
        return "send ok";
    }
}

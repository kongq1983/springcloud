package com.kq.jms.rabbitmq.direct;

import com.kq.jms.rabbitmq.callback.CallbackApplication;
import com.kq.jms.rabbitmq.callback.CallbackSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CallbackSenderTest
 *
 * @author kq
 * @date 2018-12-28
 */

@SpringBootTest(classes={CallbackApplication.class})
@RunWith(SpringRunner.class)
public class CallbackSenderTest {


    @Autowired
    private CallbackSender sender;

    @Test
    public void topic() throws Exception {
        int size = 2;
        for(int i=1;i<size;i++) {
//            sender.send("topic.callback.admin."+i, "测试消息2");
            sender.send("topic.acallback.admin."+i, "acallback测试消息2");
        }
    }



}

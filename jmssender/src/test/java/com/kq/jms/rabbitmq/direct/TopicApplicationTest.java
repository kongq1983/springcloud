package com.kq.jms.rabbitmq.direct;

import com.kq.jms.rabbitmq.topic.CoreSender;
import com.kq.jms.rabbitmq.topic.TopicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TopicApplicationTest
 *
 * @author kq
 * @date 2018-12-17
 */

@SpringBootTest(classes={TopicApplication.class})
@RunWith(SpringRunner.class)
public class TopicApplicationTest {

    @Autowired
    private CoreSender coreSender;

    @Test
    public void coreSendTest(){
        for(int i=0;i<11;i++) {
            coreSender.user("user"+i);
        }
    }

    @Test
    public void coreUserQueryTest(){
        for(int i=0;i<10;i++) {
            coreSender.userQuery("userQuery"+i);
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

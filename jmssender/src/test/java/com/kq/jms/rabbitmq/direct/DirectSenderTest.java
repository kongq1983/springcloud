package com.kq.jms.rabbitmq.direct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DirectSenderTest
 *
 * @author kq
 * @date 2018-12-17
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={DirectConfig.class})

@SpringBootTest(classes={DirectApplication.class})
@RunWith(SpringRunner.class)
public class DirectSenderTest {

    @Autowired
    private DirectSender directSender;

    @Test
    public void sendTest(){
        for(int i=0;i<100;i++) {
            directSender.sender("hello"+i);
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

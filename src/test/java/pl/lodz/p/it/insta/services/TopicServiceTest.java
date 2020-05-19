package pl.lodz.p.it.insta.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void getAll() {
        Assert.assertEquals(topicService.getAll().size(), 2);
    }

    @Test
    public void name() {

    }
}
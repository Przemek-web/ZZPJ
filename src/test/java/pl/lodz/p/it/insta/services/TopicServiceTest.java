package pl.lodz.p.it.insta.services;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lodz.p.it.insta.entities.Topic;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void getAllTest() {
        Assert.assertEquals(topicService.getAll().size(), 2);
        Assert.assertTrue(Ordering.natural().isOrdered(topicService.getAll()));
    }

    @Test
    public void getTopicTest() {
        Topic topic = topicService.getTopic(1);
        Assert.assertTrue(Ordering.natural().reverse().isOrdered(topic.getForumPosts()));
        Assert.assertEquals(topic.getForumPosts().size(), 4);
        Assert.assertEquals(topic.getTitle(), "Proponuję żeby każdy coś tu napisał o sobie :)");
    }
}
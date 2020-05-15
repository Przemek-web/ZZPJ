package pl.lodz.p.it.insta.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void getAllTest() {
        Assert.assertEquals(topicRepository.findAll().size(), 3);
    }

    @Test
    public void getPostsTest() {
        Assert.assertEquals(topicRepository.getOne(1L).getForumPosts().size(),1);
    }
}
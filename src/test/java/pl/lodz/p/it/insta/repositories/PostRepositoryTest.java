package pl.lodz.p.it.insta.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lodz.p.it.insta.entities.Post;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void getAllTest() {
        Assert.assertEquals(postRepository.findAll().size(), 4);
    }

    @Test
    public void getCommentsTest() {
        Assert.assertEquals(postRepository.getOne(2L).getComments().size(), 3);
    }
}
package pl.lodz.p.it.insta.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // The magic is here - bez tego do postu nie wczytywało komentarzy i był lazyinitializationexception
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void getAll() {
        Assert.assertEquals(postService.getAll().size(), 9);
    }
}
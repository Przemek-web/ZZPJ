package pl.lodz.p.it.insta.services;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.it.insta.entities.Comment;
import pl.lodz.p.it.insta.entities.Post;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WithMockUser(username = "ObiKenobi14", password = "Duch123")
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void getAllTest() {
        Assert.assertEquals(postService.getAll().size(), 9);
        Assert.assertTrue(Ordering.natural().isOrdered(postService.getAll()));
    }

    @Test
    public void getCommentsTest() {
        Post post = postService.getAll().get(0);
        Assert.assertEquals(post.getComments().size(), 3);
        Assert.assertTrue(Ordering.natural().isOrdered(post.getComments()));
    }

    @Test
    public void addCommentsTest() {
        postService.addCommentToPost("5", "Komentarz testowy");

        System.out.println(postService.getAll().size());

        /*Post post = postService.getAll().get(5);
        List<Comment> comments = (List<Comment>) post.getComments();
        Assert.assertEquals(comments.get(comments.size() - 1).getContent() , "Komentarz testowy");*/
    }
}
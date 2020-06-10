package pl.lodz.p.it.insta.services;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.it.insta.entities.Comment;
import pl.lodz.p.it.insta.entities.Post;
import pl.lodz.p.it.insta.repositories.CommentRepository;
import pl.lodz.p.it.insta.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WithMockUser(username = "ObiKenobi14", password = "Duch123")
@EnableConfigurationProperties
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
        postService.addCommentToPost(2, "Komentarz testowy");

        Post post = postService.getAll().get(0);
        List<Comment> comments = (List<Comment>) post.getComments();
        Comment comment = comments.get(comments.size() - 1);
        Assert.assertEquals(comment.getContent() , "Komentarz testowy");
        Assert.assertEquals(comments.size(), 4);
        Assert.assertEquals(comment.getAccount().getUsername(), "ObiKenobi14");
        Assert.assertEquals(comment.getAddDate().getMinute(), LocalDateTime.now().getMinute());
        Assert.assertEquals(comment.getPost().getDescription(), "Złapałem jakąś dzikuske, mówi że nazywa się Ygritte");

        //nie dziala - czemu ?
        /*postService.deletePostComment(comment.getId());
        Post post2 = postService.getAll().get(0);
        comments = (List<Comment>) post2.getComments();
        Assert.assertEquals(comments.size(), 3);*/
    }


}
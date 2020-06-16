package pl.lodz.p.it.insta.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lodz.p.it.insta.entities.Account;
import pl.lodz.p.it.insta.entities.Comment;
import pl.lodz.p.it.insta.entities.Post;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PostRepository postRepository;


    @Test
    public void addCommentToPost() throws Exception {
        Account account = accountRepository.findAll().stream().findFirst().orElseThrow(Exception::new);
        Post post = postRepository.findAll().stream().findFirst().orElseThrow(Exception::new);

        Comment comment = new Comment();
        comment.setContent("content");
        comment.setAddDate(LocalDateTime.now());
        comment.setAccount(account);
        comment.setPost(post);

        Assert.assertEquals(commentRepository.findAll().size(), 7);
        commentRepository.save(comment);
        Assert.assertEquals(commentRepository.findAll().size(), 8);
        //Assert.assertTrue(commentRepository.exists(Example.of(comment)));
        commentRepository.delete(comment);
        Assert.assertEquals(commentRepository.findAll().size(), 7);
        //Assert.assertFalse(commentRepository.exists(Example.of(comment)));
    }

    @Test(expected = ConstraintViolationException.class)
    public void addEmptyCommentToPost() {
        Comment comment = new Comment();
        comment.setContent("");
        commentRepository.save(comment);
        Assert.assertFalse(commentRepository.exists(Example.of(comment)));
    }
}
package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.it.insta.entities.Comment;
import pl.lodz.p.it.insta.entities.Post;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.repositories.AccountRepository;
import pl.lodz.p.it.insta.repositories.CommentRepository;
import pl.lodz.p.it.insta.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.accountRepository = accountRepository;
    }

    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll().stream().sorted().collect(Collectors.toList());
        posts.forEach(n -> n.setComments(n.getComments().stream().sorted().collect(Collectors.toList())));
        return posts;
    }

    public void addCommentToPost(long postId, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAddDate(LocalDateTime.now());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        comment.setAccount(accountRepository.findByUsername(username).orElseThrow(NoSuchElementException::new));
        comment.setPost(postRepository.findById(postId).orElseThrow(NoSuchElementException::new));
        commentRepository.save(comment);
    }

    public void deletePost(long id) {
        postRepository.delete(postRepository.getOne(id));
    }

    public void deletePostComment(long id) {
        commentRepository.delete(commentRepository.getOne(id));
    }

}

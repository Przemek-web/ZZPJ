package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.entities.ForumPost;
import pl.lodz.p.it.insta.repositories.AccountRepository;
import pl.lodz.p.it.insta.repositories.ForumPostRepository;
import pl.lodz.p.it.insta.repositories.TopicRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class ForumPostService {

    private final ForumPostRepository forumPostRepository;
    private final AccountRepository accountRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public ForumPostService(ForumPostRepository forumPostRepository, AccountRepository accountRepository, TopicRepository topicRepository) {
        this.forumPostRepository = forumPostRepository;
        this.accountRepository = accountRepository;
        this.topicRepository = topicRepository;
    }

    public void addForumPost(String content, long topicId) {
        ForumPost forumPost = new ForumPost();
        forumPost.setContent(content);
        forumPost.setAddDate(LocalDateTime.now());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        forumPost.setAccount(accountRepository.findByUsername(username).orElseThrow(NoSuchElementException::new));
        forumPost.setTopic(topicRepository.getOne(topicId));
        forumPostRepository.save(forumPost);
    }

    public void deleteForumPost(long id){
        forumPostRepository.delete(forumPostRepository.getOne(id));
    }

    public void updateForumPost(long id, String content){
        ForumPost editedPost = forumPostRepository.findById(id).orElseThrow(NoSuchElementException::new);
        editedPost.setContent(content);
        forumPostRepository.save(editedPost);
    }
}

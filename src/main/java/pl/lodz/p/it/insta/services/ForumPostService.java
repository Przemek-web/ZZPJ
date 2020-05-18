package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.dtos.EditForumPostDto;
import pl.lodz.p.it.insta.entities.ForumPost;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.repositories.AccountRepository;
import pl.lodz.p.it.insta.repositories.ForumPostRepository;
import pl.lodz.p.it.insta.repositories.TopicRepository;

import java.util.List;

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

    public List<ForumPost> getAll() {
        return forumPostRepository.findAll();
    }

    public void addForumPost(String content, long accountId, long topicId) {
        ForumPost forumPost = new ForumPost();
        forumPost.setContent(content);
        forumPost.setAccount(accountRepository.getOne(accountId));
        forumPost.setTopic(topicRepository.getOne(topicId));
        forumPostRepository.save(forumPost);
    }

    public void deleteForumPost(long id){
        forumPostRepository.delete(forumPostRepository.getOne(id));
    }

    public void updateForumPost(long id, EditForumPostDto editForumPostDto){
        ForumPost editedPost = forumPostRepository.findById(id).orElse(new ForumPost());
        editedPost.setTitle(editForumPostDto.getContent());
        editedPost.setAccount(accountRepository.findById(editForumPostDto.getAccountId()).orElse(null));
        editedPost.setTopic(topicRepository.findById(editForumPostDto.getTopicId()).orElse(null));
        forumPostRepository.save(editedPost);
    }
}

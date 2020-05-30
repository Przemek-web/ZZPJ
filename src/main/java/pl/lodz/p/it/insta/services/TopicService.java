package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.dtos.EditTopicDto;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.repositories.AccountRepository;
import pl.lodz.p.it.insta.repositories.TopicRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    private final AccountRepository accountRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, AccountRepository accountRepository) {
        this.topicRepository = topicRepository;
        this.accountRepository = accountRepository;
    }

    public List<Topic> getAll() {
        List<Topic> topics = topicRepository.findAll().stream().sorted().collect(Collectors.toList());
        topics.forEach(t -> t.setForumPosts(t.getForumPosts().stream().sorted().collect(Collectors.toList())));
        return topics;
    }

    public Topic getTopic(long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(NoSuchElementException::new);
        topic.setForumPosts(topic.getForumPosts().stream().sorted().collect(Collectors.toList()));
        return topic;
    }

    public void addTopic(String title, long accountId) {
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setAccount(accountRepository.findById(accountId).orElse(null));
        topicRepository.save(topic);
    }

    public void deleteTopic(long id) {
        topicRepository.delete(topicRepository.getOne(id));
    }

    public void updateTopic(long id, EditTopicDto editTopicDto) {
        Topic editedTopic = topicRepository.findById(id).orElse(new Topic());
        editedTopic.setTitle(editTopicDto.getTitle());
        editedTopic.setAccount(accountRepository.findById(editTopicDto.getAccountId()).orElse(null));
        topicRepository.save(editedTopic);
    }
}

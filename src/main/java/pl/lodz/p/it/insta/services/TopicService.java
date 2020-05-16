package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.repositories.AccountRepository;
import pl.lodz.p.it.insta.repositories.TopicRepository;

import java.util.List;

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
        return topicRepository.findAll();
    }

    public void addTopic(String title, int accountId){
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setAccount(accountRepository.findById((long) accountId));
        topicRepository.save(topic);
    }
}

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

    public Topic getTopic(long id){return topicRepository.findById(id).orElse(null);}

    public void addTopic(String title, long accountId){
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setAccount(accountRepository.findById(accountId).orElse(null));
        topicRepository.save(topic);
    }
}

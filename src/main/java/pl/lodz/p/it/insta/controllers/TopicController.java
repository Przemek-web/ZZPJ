package pl.lodz.p.it.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.it.insta.dtos.NewTopicDto;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.services.TopicService;

import java.util.List;

@RestController
@RequestMapping("forum")
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    // http://localhost:8080/forum/
    @GetMapping(produces = "application/json")
    public List<Topic> getAll() {
        return topicService.getAll();
    }

    @PostMapping("/addTopic")
    public void addTopic(@RequestBody NewTopicDto newTopicDto){
        String title = newTopicDto.getTitle();
        int accountId = newTopicDto.getAccountId();
        topicService.addTopic(title,accountId);
    }
}

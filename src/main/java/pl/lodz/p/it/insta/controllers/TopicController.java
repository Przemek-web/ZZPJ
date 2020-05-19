package pl.lodz.p.it.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.it.insta.dtos.EditForumPostDto;
import pl.lodz.p.it.insta.dtos.EditTopicDto;
import pl.lodz.p.it.insta.dtos.NewForumPostDto;
import pl.lodz.p.it.insta.dtos.NewTopicDto;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.services.ForumPostService;
import pl.lodz.p.it.insta.services.TopicService;

import java.util.List;

@RestController
@RequestMapping("forum")
public class TopicController {

    private TopicService topicService;
    private ForumPostService forumPostService;

    @Autowired
    public TopicController(TopicService topicService,ForumPostService forumPostService) {
        this.topicService = topicService;
        this.forumPostService = forumPostService;
    }

    // http://localhost:8080/forum/
    @GetMapping(produces = "application/json")
    public List<Topic> getAll() {
        return topicService.getAll();
    }

    // http://localhost:8080/forum/topic/id
    @GetMapping(value = "/topic/{id}",produces = "application/json")
    public Topic getTopic(@PathVariable Long id) {
        return topicService.getTopic(id);
    }

    // http://localhost:8080/forum/addTopic
    @PostMapping("/addTopic")
    public void addTopic(@RequestBody NewTopicDto newTopicDto){
        String title = newTopicDto.getTitle();
        long accountId = newTopicDto.getAccountId();
        topicService.addTopic(title,accountId);
    }

    // http://localhost:8080/forum/addForumPost
    @PostMapping("/addForumPost")
    public void addForumPost(@RequestBody NewForumPostDto newForumPostDto){
        String content = newForumPostDto.getContent();
        long accountId = newForumPostDto.getAccountId();
        long topicId  = newForumPostDto.getTopicId();
        forumPostService.addForumPost(content,accountId,topicId);
    }

    // http://localhost:8080/forum/topic/id
    @DeleteMapping("/topic/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    // http://localhost:8080/forum/forumPost/id
    @DeleteMapping("/forumPost/{id}")
    public void deleteForumPost(@PathVariable Long id) {
        forumPostService.deleteForumPost(id);
    }

    @PutMapping("/forumPost/{id}")
    public void updateTopic(@PathVariable Long id,@RequestBody EditTopicDto editTopicDto){
        topicService.updateTopic(id, editTopicDto);
    }

    @PutMapping("/topic/{id}")
    public void updateForumPost(@PathVariable Long id,@RequestBody EditForumPostDto editForumPostDto){
        forumPostService.updateForumPost(id, editForumPostDto);
    }
}

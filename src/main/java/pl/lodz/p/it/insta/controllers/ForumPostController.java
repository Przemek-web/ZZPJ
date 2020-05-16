package pl.lodz.p.it.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.it.insta.dtos.NewTopicDto;
import pl.lodz.p.it.insta.entities.ForumPost;
import pl.lodz.p.it.insta.services.ForumPostService;

import java.util.List;

@RestController
@RequestMapping("forumPosts")
public class ForumPostController {

    private ForumPostService forumPostService;

    @Autowired
    public ForumPostController(ForumPostService forumPostService) {
        this.forumPostService = forumPostService;
    }

    // http://localhost:8080/forumPosts/
    @GetMapping(produces = "application/json")
    public List<ForumPost> getAll() {
        return forumPostService.getAll();
    }

    @PostMapping("/addForumPost")
    public void addTopic(@RequestBody NewTopicDto newTopicDto){
    }
}

package pl.lodz.p.it.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.it.insta.dtos.NewCommentDto;
import pl.lodz.p.it.insta.dtos.NewPostDto;
import pl.lodz.p.it.insta.dtos.NewTopicDto;
import pl.lodz.p.it.insta.entities.Post;
import pl.lodz.p.it.insta.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // http://localhost:8080/posts/
    @GetMapping(produces = "application/json")
    public List<Post> getAll() {
        return postService.getAll();
    }

    // http://localhost:8080/posts/addCommentToPost/
    @PostMapping("/addCommentToPost")
    public void addCommentToPost(@RequestBody NewCommentDto newCommentDto) {
        String postId= newCommentDto.getPostId();
        String content=newCommentDto.getContent();
        postService.addCommentToPost(postId, content);
    }

    // http://localhost:8080/posts/addPost
    @PostMapping(value = "/addPost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPost(@RequestBody NewPostDto newPostDto){
        postService.addPost(newPostDto.getDescription(), newPostDto.getLob());

    }

}

package pl.lodz.p.it.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.it.insta.dtos.NewCommentDto;
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
        long postId = newCommentDto.getPostId();
        String content = newCommentDto.getContent();
        postService.addCommentToPost(postId, content);
    }

    // http://localhost:8080/posts/post/id
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    // http://localhost:8080/posts/postComment/id
    @DeleteMapping("/postComment/{id}")
    public void deletePostComment(@PathVariable Long id) {
        postService.deletePostComment(id);
    }
}

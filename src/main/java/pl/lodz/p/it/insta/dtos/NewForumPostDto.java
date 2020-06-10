package pl.lodz.p.it.insta.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewForumPostDto {
    private String content;
    private long topicId;

    public NewForumPostDto(String content, long topicId) {
        this.content = content;
        this.topicId = topicId;
    }

    public NewForumPostDto() {
    }
}

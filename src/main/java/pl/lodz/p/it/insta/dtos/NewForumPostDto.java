package pl.lodz.p.it.insta.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewForumPostDto {
    String content;
    long accountId;
    long topicId;
}

package pl.lodz.p.it.insta.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

    private Long id;
    private String title;
    private LocalDateTime addDate;
    private AccountSummaryDto account;
    private Collection<ForumPostDto> forumPosts = new ArrayList<>();
}

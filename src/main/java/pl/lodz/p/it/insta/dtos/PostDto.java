package pl.lodz.p.it.insta.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;
    private byte[] lob;
    private String description;
    private LocalDateTime addDate;
    private AccountSummaryDto account;
    private List<CommentDto> comments = new ArrayList<>();
}

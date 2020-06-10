package pl.lodz.p.it.insta.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTopicDto {
    private String title;

    public NewTopicDto(String title) {
        this.title = title;
    }

    public NewTopicDto() {
    }
}

package pl.lodz.p.it.insta.dtos;

import lombok.Getter;
import lombok.Setter;


public class EditForumPostDto {
    String content;
    long accountId;
    long topicId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }
}

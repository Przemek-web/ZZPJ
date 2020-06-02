package pl.lodz.p.it.insta.dtos;


public class EditForumPostDto {
    String content;
    long postId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}

package brian.example.boot.jpa.domain.hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "user_id")
    private String userId;
    private String subject;
    private String content;
    @Column(name="created_datetime")
    private LocalDateTime createdDatetime;

    public Post(){}

    public Post(String userId, String subject, String content){
        this.userId = userId;
        this.subject = subject;
        this.content = content;
        this.createdDatetime = LocalDateTime.now();
    }

    public int getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
}

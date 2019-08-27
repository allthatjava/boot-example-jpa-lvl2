package brian.example.boot.jpa.domain.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_USER")
public class TestUser {

    @Id
    private String userId;
    private String pw;
    private String name;
    private String title;
    private int age;

    private TestUser(){
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

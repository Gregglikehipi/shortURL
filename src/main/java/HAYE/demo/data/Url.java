package HAYE.demo.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Url implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String userName;

    private String fullUrl;

    private String smallUrl;

    private int count;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Url() {
    }

    public Url(String userName, String fullUrl, String smallUrl) {
        this.userName = userName;
        this.fullUrl = fullUrl;
        this.smallUrl = smallUrl;
        count = 0;
    }

    public Url(Long id, String userName,String fullUrl, String smallUrl) {
        this.id = id;
        this.userName = userName;
        this.fullUrl = fullUrl;
        this.smallUrl = smallUrl;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void CountPlus() {
        this.count += 1;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }
}

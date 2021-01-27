package runner.entities;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private Integer rating;

    public Account() {
    }

    public Account(String username, String password, Integer rating) {
        this.username = username;
        this.password = password;
        this.rating = rating;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getRating() { return rating; }

    public void setRating(Integer rating) { this.rating = rating; }
}

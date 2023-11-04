package vn.edu.iuh.fit.backends.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "middle_name", length = 50)
    private String middleName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password_hash", length = 64, nullable = false)
    private String passwordHash;
    @Column(name = "registerd_at", columnDefinition = "datetime(6)", nullable = false)
    private Instant registerAt;
    @Column(name = "last_login", columnDefinition = "datetime(6)")
    private Instant lastLogin;
    @Column(name = "intro", columnDefinition = "tinytext")
    private String intro;
    @Column(name = "profile", columnDefinition = "tinytext")
    private String profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PostComment> comments;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Post> posts;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, Instant registerAt, Instant lastLogin, String intro, String profile, Set<PostComment> comments, Set<Post> posts) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.comments = comments;
        this.posts = posts;
    }
}

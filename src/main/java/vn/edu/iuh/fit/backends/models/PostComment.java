package vn.edu.iuh.fit.backends.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.stream.events.Comment;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(columnDefinition = "bit(1)", nullable = false)
    private boolean published;
    @Column(name = "create_at", columnDefinition = "datetime(6)", nullable = false)
    private Instant createAt;
    @Column(name = "published_at", columnDefinition = "datetime(6)")
    private Instant publishedAt;
    @Column(columnDefinition = "tinytext")
    private String content;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "parent_id", unique = true)
    private PostComment parent;
    @ManyToOne
    @JoinColumn(name = "post_id", unique = true, nullable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    public PostComment(String title, boolean published, Instant createAt, Instant publishedAt, String content, Set<PostComment> postComments, PostComment parent, Post post, User user) {
        this.title = title;
        this.published = published;
        this.createAt = createAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
        this.parent = parent;
        this.post = post;
        this.user = user;
    }
}

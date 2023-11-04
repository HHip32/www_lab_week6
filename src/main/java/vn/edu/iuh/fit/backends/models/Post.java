package vn.edu.iuh.fit.backends.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(length = 75, nullable = false)
    private String title;
    @Column(name = "meta_title", length = 100)
    private String metaTitle;
    @Column(columnDefinition = "tinytext")
    private String summary;
    @Column(columnDefinition = "bit(1)", nullable = false)
    private boolean published;
    @Column(name = "create_at", columnDefinition = "datetime(6)", nullable = false)
    private Instant createdAt;
    @Column(name = "update_at", columnDefinition = "datetime(6)")
    private Instant updatedAt;
    @Column(name = "publish_at", columnDefinition = "datetime(6)")
    private Instant publishedAt;
    @Column(columnDefinition = "tinytext")
    private String content;
    @OneToMany (mappedBy = "parent", cascade = CascadeType.ALL)
    @Column(unique = true, nullable = true)
    private Set<Post> posts;
    @ManyToOne
    @JoinColumn(name = "authorId", unique = true)
    private User author;

}

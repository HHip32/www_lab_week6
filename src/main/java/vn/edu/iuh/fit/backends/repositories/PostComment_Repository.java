package vn.edu.iuh.fit.backends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backends.models.PostComment;

public interface PostComment_Repository extends JpaRepository<PostComment, Long> {
}

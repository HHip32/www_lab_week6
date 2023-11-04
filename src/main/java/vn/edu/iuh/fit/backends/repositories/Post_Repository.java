package vn.edu.iuh.fit.backends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backends.models.Post;

public interface Post_Repository extends JpaRepository<Post, Long> {

}
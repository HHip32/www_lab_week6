package vn.edu.iuh.fit.backends.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backends.repositories.PostComment_Repository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostComment_Service {
    private PostComment_Repository postCommentRepository;
}

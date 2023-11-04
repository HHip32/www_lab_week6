package vn.edu.iuh.fit.backends.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backends.repositories.Post_Repository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class Post_Service{
    private Post_Repository postRepository;
}

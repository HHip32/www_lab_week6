package vn.edu.iuh.fit.backends.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backends.models.User;
import vn.edu.iuh.fit.backends.repositories.User_Repository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class User_Service {
    private User_Repository userRepository;

    public User login(String email, String password) {
        return userRepository.findByEmailAndPasswordHash(email, password).orElse(null);
    }
}

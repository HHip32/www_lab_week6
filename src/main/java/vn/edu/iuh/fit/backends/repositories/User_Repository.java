package vn.edu.iuh.fit.backends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backends.models.User;

import java.util.Optional;

public interface User_Repository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPasswordHash(String email, String passWordHash);
}

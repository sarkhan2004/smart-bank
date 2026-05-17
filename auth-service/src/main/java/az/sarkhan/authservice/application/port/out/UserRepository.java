package az.sarkhan.authservice.application.port.out;

import az.sarkhan.authservice.domain.model.User;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
package web.service;

import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    // Read operations
    List<User> getAllUsers();
    Optional<Optional<User>> getUserById(Long id);
    boolean existsById(Long id);

    // Write operations
    User createUser(User user);      // For new user creation
    User saveUser(User user);        // Generic save (create or update)
    User updateUser(Long id, User user);  // Specific update operation
    void deleteUser(Long id);

    // Additional common methods
    boolean existsByEmail(String email);  // Very useful for registration
}
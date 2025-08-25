package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}

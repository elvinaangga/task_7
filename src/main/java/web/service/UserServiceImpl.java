package web.service;

import org.springframework.stereotype.Service;
import web.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(Long id) {

    }
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.dao.UserDao;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<Optional<User>> getUserById(Long id) {
        return Optional.ofNullable(userDao.findById(id));
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User createUser(User user) {
        // Additional business logic can go here
        return userDao.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        user.setId(id); // Ensure ID is set
        return userDao.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}

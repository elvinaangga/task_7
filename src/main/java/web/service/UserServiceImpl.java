package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final Validator validator;

    @Autowired
    public UserServiceImpl(UserDao userDao, Validator validator) {
        this.userDao = userDao;
        this.validator = validator;
    }
    @Override
    public List<User> findAll() {
        return  userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            String messages = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));
            throw new RuntimeException("Validation failed: " + messages);
        }
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

}



//    @Override
//    @Transactional
//    public void update(User user) {
//        userDao.update(user);
//    }


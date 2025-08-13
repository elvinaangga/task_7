package web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.entity.User;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}

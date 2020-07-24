package usergroup.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import usergroup.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository("Hibernate")
//@Primary
public class UserDAOHibernateImpl implements UserDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }


    @Override
    @Transactional
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }



    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        User user = findById(id);
        entityManager.remove(user);
    }
};


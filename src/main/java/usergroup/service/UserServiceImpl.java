package usergroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usergroup.dao.UserDAO;
import usergroup.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("Hibernate")
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }
}

package usergroup.dao;

import org.springframework.stereotype.Repository;
import usergroup.model.User;

import javax.transaction.Transactional;
import java.util.List;


public interface UserDAO {
    public List<User> findAll();
    public User findById(long id);
    public void create(User user);
    public void update(User user);
    public void deleteById(long id);
}


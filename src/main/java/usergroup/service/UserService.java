package usergroup.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usergroup.model.User;

import java.util.List;


public interface UserService {
    public List<User> findAll();
    public User findById(long id);
    public void create(User user);
    public void update(User user);
    public void deleteById(long id);
}

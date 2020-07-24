package usergroup.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import usergroup.model.User;

import java.util.List;

@Repository("JDBC")
public class UserDAOJDBCImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(long id) {

    }
}

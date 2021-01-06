package qmstore.user.dao;

import org.springframework.stereotype.Repository;
import qmstore.user.pojo.User;

@Repository
public interface UserDao {
    public String getPassword(String userId);

    public User getUser(String userId);

}

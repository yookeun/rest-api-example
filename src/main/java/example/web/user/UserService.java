package example.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yookeun on 2017. 2. 25..
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDto select(String username) {
        return userDao.select(username);
    }
}

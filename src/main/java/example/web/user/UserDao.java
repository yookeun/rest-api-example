package example.web.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yookeun on 2017. 2. 25..
 */
@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public UserDto select(String username) {
        return sqlSession.selectOne("userMapper.select", username);
    }
}

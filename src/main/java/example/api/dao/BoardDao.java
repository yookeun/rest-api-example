package example.api.dao;

import example.api.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yookeun on 2017. 2. 26..
 */
@Repository
public class BoardDao {

    @Autowired
    private SqlSession sqlSession;

    public List<BoardDto> selectListBoard() {
        return sqlSession.selectList("boardMapper.selectListBoard");
    }

    public BoardDto selectOneBoard(int id) {
        return sqlSession.selectOne("boardMapper.selectOneBoard", id);
    }

    public int insertBoard(BoardDto boardDto) {
        return sqlSession.insert("boardMapper.insertBoard", boardDto);
    }
}

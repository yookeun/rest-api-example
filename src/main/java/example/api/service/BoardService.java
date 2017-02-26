package example.api.service;

import example.api.dao.BoardDao;
import example.api.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yookeun on 2017. 2. 26..
 */
@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public List<BoardDto> selectListBoard() {
        return boardDao.selectListBoard();
    }

    public BoardDto selectOneBoard(int id) {
        return boardDao.selectOneBoard(id);
    }

    public int insertBoard(BoardDto boardDto) {
        return boardDao.insertBoard(boardDto);
    }
}

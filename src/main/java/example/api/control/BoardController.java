package example.api.control;

import example.api.dto.BoardDto;
import example.api.service.BoardService;
import example.common.ResultCodeType;
import example.common.ResultJson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yookeun on 2017. 2. 26..
 */
@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ApiOperation(value = "전체 게시판 조회")
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ResultJson selectListBoard() {
        ResultJson resultJson = new ResultJson();
        List<BoardDto> list = boardService.selectListBoard();
        resultJson.setItems(list);
        resultJson.setTotal(list.size());
        resultJson.setResultCode(ResultCodeType.SUCCESS.getCode());
        resultJson.setMsg(ResultCodeType.SUCCESS.getMsg());
        return resultJson;
    }

    @ApiOperation(value = "해당 게시판 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "게시판 고유키", required = true, dataType = "string", paramType = "path", defaultValue = ""),
    })
    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public ResultJson selectOneBoard(@PathVariable("id") Integer id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setObject(boardService.selectOneBoard(id));
        resultJson.setResultCode(ResultCodeType.SUCCESS.getCode());
        resultJson.setMsg(ResultCodeType.SUCCESS.getMsg());
        return resultJson;
    }

    @ApiOperation(value = "게시판 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "내용", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ResultJson insertBoard(
            @RequestParam(value = "title", required = true) String title,
            @RequestParam(value = "content", required = true) String content){

        ResultJson resultJson = new ResultJson();
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardService.insertBoard(boardDto);

        resultJson.setResultCode(ResultCodeType.SUCCESS.getCode());
        resultJson.setMsg(ResultCodeType.SUCCESS.getMsg());
        return resultJson;
    }
}

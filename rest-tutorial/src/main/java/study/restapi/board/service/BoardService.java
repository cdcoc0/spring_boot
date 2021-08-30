package study.restapi.board.service;

import org.springframework.stereotype.Service;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> selectBoardList() {
        return boardMapper.findAll();
    }
}

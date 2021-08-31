package study.restapi.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.mapper.BoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;

//    public BoardService(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }

    @Transactional(readOnly = true)
    public List<BoardDto> selectBoardList() {
        return boardMapper.findAll();
    }

    public void insertBoard(BoardDto board) {
        boardMapper.saveBoard(board);
    }

    public BoardDto selectBoard(int boardIdx) {
        boardMapper.updateHitCount(boardIdx);
        BoardDto board = boardMapper.selectBoard(boardIdx);

        return board;
    }

    public void updateBoard(BoardDto board) {
        boardMapper.boardUpdate(board);
    }

    public void deleteBoard(int boardIdx) {
        boardMapper.boardRemove(boardIdx);
    }
}

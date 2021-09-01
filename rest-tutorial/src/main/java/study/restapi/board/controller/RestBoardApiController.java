package study.restapi.board.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
//Controller + ResponseBody
public class RestBoardApiController {

    private final BoardService boardService;

    /*public RestBoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }*/

    @GetMapping("/api/board")
    //@ResponseBody
    public List<BoardDto> boardList() {
        return boardService.selectBoardList();
    }

    @PostMapping("/api/board/write")
    public void insertBoard(@RequestBody BoardDto board) {
        boardService.insertBoard(board);
    }

    @GetMapping("/api/board/{boardIdx}")
    public BoardDto readBoard(@PathVariable("boardIdx") int boardIdx) {
        return boardService.selectBoard(boardIdx);
    }

    @PutMapping("/api/board/{boardIdx}")
    public String updateBoard(@RequestBody BoardDto board) {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @DeleteMapping("/api/board/{boardIdx}")
    public String deleteboard(@PathVariable("boardIdx") int boardIdx) {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}

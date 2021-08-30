package study.restapi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/boardList")
    public String openBoardList(Model model) {
        List<BoardDto> list = boardService.selectBoardList();
        model.addAttribute("list", list);
        return "board/boardList";
    }

    @GetMapping("/board/boardWrite")
    public String openBoardWrite() {
        return "board/boardWrite";
    }

    @PostMapping("/board/boardWrite")
    public String insertBoard(BoardDto board) {
        boardService.insertBoard(board);
        return "redirect:/board/boardList";
    }

    @GetMapping("/board/boardRead/{boardIdx}")
    public String readBoard(@PathVariable("boardIdx") int boardIdx, Model model) {
        BoardDto board = boardService.selectBoard(boardIdx);
        model.addAttribute("board", board);
        return "board/boardRead";
    }
}

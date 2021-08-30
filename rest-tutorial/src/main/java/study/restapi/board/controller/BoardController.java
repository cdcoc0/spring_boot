package study.restapi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/openBoardList")
    public String openBoardList(Model model) {
        List<BoardDto> list = boardService.selectBoardList();
        model.addAttribute("list", list);
        return "board/boardList";
    }
}

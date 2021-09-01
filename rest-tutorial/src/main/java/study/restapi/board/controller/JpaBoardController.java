package study.restapi.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.restapi.board.entity.BoardEntity;
import study.restapi.board.service.JpaBoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JpaBoardController {
    private final JpaBoardService jpaBoardService;

    @GetMapping("/jpa/board")
    public String boardList(Model model) {
        List<BoardEntity> list = jpaBoardService.selectBoardList();
        //원래는 엔티티 직접사용 절대 금지
        model.addAttribute("list", list);
        return "board/boardList";
    }

    @GetMapping("/jpa/board/write")
    public String openBoardWrite() {
        return "board/boardWrite";
    }

    @PostMapping("/jpa/board/write")
    public String writeBoard(BoardEntity board) {
        jpaBoardService.saveBoard(board);
        return "redirect:/jpa/board";
    }

    @GetMapping("/jpa/board/{boardIdx}")
    public String readBoard(@PathVariable("boardIdx") int idx, Model model) {
        BoardEntity board = jpaBoardService.selectBoard(idx);
        model.addAttribute("board", board);
        return "board/boardRead";
    }

    @PostMapping("/jpa/board/{boardIdx}")
    public String updateBoard(BoardEntity board) {
        jpaBoardService.saveBoard(board);
        return "redirect:/jpa/board";
    }

    @PostMapping("/jpa/board/{boardIdx}")
    public String deleteBaoard(@PathVariable("boardIdx") int idx) {
        jpaBoardService.deleteBoard(idx);
        return "redirect:/jpa/board";
    }
}

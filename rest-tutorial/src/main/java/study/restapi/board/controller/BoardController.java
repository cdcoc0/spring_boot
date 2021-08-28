package study.restapi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.restapi.board.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
}

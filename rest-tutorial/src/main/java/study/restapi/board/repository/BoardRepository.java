package study.restapi.board.repository;

import study.restapi.board.dto.BoardDto;

import java.util.List;


public interface BoardRepository {
    List<BoardDto> findAll();
}

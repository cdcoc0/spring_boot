package study.restapi.board.repository;

import org.springframework.data.repository.CrudRepository;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.entity.BoardEntity;

import java.util.List;

public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {
    public List<BoardEntity> findAllByOrderByBoardIdxDesc();
}

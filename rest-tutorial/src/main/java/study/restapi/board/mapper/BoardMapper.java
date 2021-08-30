package study.restapi.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.repository.BoardRepository;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM t_board WHERE deleted_yn = 'N'")
    List<BoardDto> findAll();
}

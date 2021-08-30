package study.restapi.board.mapper;

import org.apache.ibatis.annotations.*;
import study.restapi.board.dto.BoardDto;
import study.restapi.board.repository.BoardRepository;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM t_board WHERE deleted_yn = 'N'")
    List<BoardDto> findAll();

    @Insert("INSERT INTO t_board (title, contents, created_datetime, creator_id) VALUES (#{title}, #{contents}, NOW(), 'admin')")
    void saveBoard(BoardDto board);

    @Update("UPDATE t_board SET hit_cnt = hit_cnt + 1 WHERE board_idx = #{boardIdx}")
    void updateHitCount(int boardIdx);

    @Select("SELECT board_idx, title, contents, hit_cnt, created_datetime, creator_id FROM t_board" +
            " WHERE board_idx = #{boardIdx} AND deleted_yn = 'N'")
    BoardDto selectBoard(int boardIdx);

    @Update("UPDATE t_board SET title = #{title}, contents = #{contents}, updated_datetime = NOW(), updater_id = 'admin'" +
            " WHERE board_idx = #{board_idx}")
    void boardUpdate(BoardDto board);

    @Update("UPDATE t_board SET deleted_yn = 'Y' WHERE board_idx = #{boardIdx}")
    void boardRemove(int boardIdx);
}

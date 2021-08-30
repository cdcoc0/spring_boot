package study.restapi.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardDto {
    private int board_idx;
    private String title;
    private String contents;
    private int hit_cnt;
    private String creator_id;
    private LocalDateTime created_datetime;
    private String updater_id;
    private LocalDateTime update_datetime;
}

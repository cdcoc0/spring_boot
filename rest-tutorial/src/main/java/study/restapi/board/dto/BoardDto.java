package study.restapi.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardDto {
    private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private String creatorId;
    private LocalDateTime createdDatetime;
    private String updaterId;
    private LocalDateTime updateDatetime;
}

package study.restapi.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="t_jpa_board")
@NoArgsConstructor
@Getter @Setter
public class BoardEntity {

    @Id @GeneratedValue
    private int boardIdx;

    @NotNull
    private String title;

    @NotNull
    private String contents;

    @NotNull
//    @Column(name = hit_cnt)
    private int hit_cnt;

    @NotNull
    private String creator_id;

    @NotNull
    private LocalDateTime created_datetime = LocalDateTime.now();

    private String updater_id;

    private LocalDateTime updated_datetime;
}

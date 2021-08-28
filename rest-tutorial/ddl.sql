drop table if exists t_board CASCADE
create table t_board (
    boardIdx INT(11) NOT NULL AUTO_INCREMENT COMMENT '글 번호',
    title VARCHAR(300) NOT NULL COMMENT '제목',
    contents TEXT NOT NULL COMMENT '내용',
    hitCnt SMALLINT(10) NOT NULL DEFAULT '0' COMMENT '조회수',
    createdDatetime DATETIME NOT NULL COMMENT '작성시간',
    creatorId VARCHAR(50) NOT NULL COMMENT '작성자',
    updatedDatetime DATETIME DEFAULT NULL COMMENT '수정 시간',
    updaterId VARCHAR(50) DEFAULT NULL COMMENT '수정자',
    deletedYn CHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
    PRIMARY KEY (board_idx)
);
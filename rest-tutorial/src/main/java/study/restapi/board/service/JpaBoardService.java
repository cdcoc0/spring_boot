package study.restapi.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.restapi.board.entity.BoardEntity;
import study.restapi.board.repository.JpaBoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaBoardService {

    private final JpaBoardRepository jpaBoardRepository;

    public List<BoardEntity> selectBoardList() {
        return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
    }

    public void saveBoard(BoardEntity board) {
        jpaBoardRepository.save(board);
    }

    public BoardEntity selectBoard(int idx) {
        Optional<BoardEntity> optional = jpaBoardRepository.findById(idx);
        if(optional.isPresent()) {
            BoardEntity board = optional.get();
            board.setHit_cnt(board.getHit_cnt() + 1);
            jpaBoardRepository.save(board);

            return board;
        } else {
            throw new NullPointerException();
        }
    }

    public void deleteBoard(int idx) {
        jpaBoardRepository.deleteById(idx);
    }
}

package msa.devmix.repository;

import msa.devmix.domain.board.Board;
import msa.devmix.repository.query.BoardRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PagedModel;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

    @Query("select b from Board b where b.id = :id and b.user.id = :userId")
    Board a(@Param("id") Long id, @Param("userId") Long userId);

    Optional<Board> findByIdAndUserId(Long id, Long userId);

    Optional<List<Board>> findByUserId(Long userId, Pageable pageable);

    @Modifying
    @Query("update Board b set b.viewCount = b.viewCount + 1 where b.id = :boardId")
    void increaseViewCount(@Param("boardId") Long boardId);

    @Modifying
    @Query("UPDATE Board b SET b.commentCount = b.commentCount + 1 WHERE b.id = :boardId")
    void increaseCommentCount(@Param("boardId") Long boardId);
}

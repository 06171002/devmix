package msa.devmix.repository.query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface BoardRepositoryCustom {
    List<BoardQueryDto> findBoardWithUserQueryDtos();
    List<BoardQueryDto> findBoardByUserQueryDtos(List<BoardQueryDto> result);

    List<BoardQueryDto> findBoards(int pageNumber, int pageSize);
    Long countBoards();
    Map<Long, List<BoardPositionQueryDto>> findBoardPositionQueryDtos(List<Long> boardIds);
    Map<Long, List<BoardTechStackQueryDto>> findBoardTechStackQueryDtos(List<Long> boardIds);

    SpecificBoardQueryDto findBoard(Long boardId);
    List<BoardPositionQueryDto> findBoardPositionQueryDto(Long boardId);
    List<BoardTechStackQueryDto> findBoardTechStackQueryDto(Long boardId);
}

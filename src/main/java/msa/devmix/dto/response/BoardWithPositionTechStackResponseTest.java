package msa.devmix.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;
import msa.devmix.repository.query.BoardPositionQueryDto;
import msa.devmix.repository.query.BoardTechStackQueryDto;
import msa.devmix.repository.query.SpecificBoardQueryDto;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardWithPositionTechStackResponseTest {

    private Long boardId;
    private String title;
    private String content;
    private String createdBy;
    private Location location;
    private RecruitmentStatus recruitmentStatus;
    private LocalDate recruitEndDate;
    private String projectPeriod;
    private Long viewCount;

    private List<BoardPositionQueryDto> positions;
    private List<BoardTechStackQueryDto> techStacks;

    public static BoardWithPositionTechStackResponseTest of(Long boardId,
                                                            String title,
                                                            String content,
                                                            String createdBy,
                                                            Location location,
                                                            RecruitmentStatus recruitmentStatus,
                                                            LocalDate recruitEndDate,
                                                            String projectPeriod,
                                                            Long viewCount,
                                                            List<BoardPositionQueryDto> positions,
                                                            List<BoardTechStackQueryDto> techStacks) {
        return new BoardWithPositionTechStackResponseTest(
                boardId,
                title,
                content,
                createdBy,
                location,
                recruitmentStatus,
                recruitEndDate,
                projectPeriod,
                viewCount,
                positions,
                techStacks);
    }

    public static BoardWithPositionTechStackResponseTest from(SpecificBoardQueryDto specificBoardQueryDto) {
        return BoardWithPositionTechStackResponseTest.of(
                specificBoardQueryDto.getBoardId(),
                specificBoardQueryDto.getTitle(),
                specificBoardQueryDto.getContent(),
                specificBoardQueryDto.getCreatedBy(),
                specificBoardQueryDto.getLocation(),
                specificBoardQueryDto.getRecruitmentStatus(),
                specificBoardQueryDto.getRecruitEndDate(),
                specificBoardQueryDto.getProjectPeriod(),
                specificBoardQueryDto.getViewCount(),
                specificBoardQueryDto.getPositions(),
                specificBoardQueryDto.getTechStacks());
    }
}

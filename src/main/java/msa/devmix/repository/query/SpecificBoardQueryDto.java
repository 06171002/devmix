package msa.devmix.repository.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(of = "boardId")
public class SpecificBoardQueryDto {

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
//    private List<BoardCommentQueryDto> comments;

    public SpecificBoardQueryDto(Long boardId,
                                 String title,
                                 String content,
                                 String createdBy,
                                 Location location,
                                 RecruitmentStatus recruitmentStatus,
                                 LocalDate recruitEndDate,
                                 String projectPeriod,
                                 Long viewCount) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.location = location;
        this.recruitmentStatus = recruitmentStatus;
        this.recruitEndDate = recruitEndDate;
        this.projectPeriod = projectPeriod;
        this.viewCount = viewCount;
    }



}

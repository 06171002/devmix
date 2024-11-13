package msa.devmix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardWithPositionTechStackDto {

    private Long boardId;
    private String title;
    private String content;
    private String imageUrl;
    private String location;
    private RecruitmentStatus recruitmentStatus;
    private Long viewCount;
    private String projectPeriod;
    private LocalDate endDate;
    private UserDto userDto;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private String createdBy;
    private List<BoardTechStackDto> boardTechStackDtos;
    private List<BoardPositionDto> boardPositionDtos;

    public static BoardWithPositionTechStackDto of(BoardDto boardDto,
                                                   List<BoardPositionDto> boardPositionDtos,
                                                   List<BoardTechStackDto> boardTechStackDtos) {
        return new BoardWithPositionTechStackDto(
                boardDto.getBoardId(),
                boardDto.getTitle(),
                boardDto.getContent(),
                boardDto.getImageUrl(),
                boardDto.getLocation(),
                boardDto.getRecruitmentStatus(),
                boardDto.getViewCount(),
                boardDto.getProjectPeriod(),
                boardDto.getRecruitEndDate(),
                boardDto.getUserDto(),
                boardDto.getCreatedAt(),
                boardDto.getLastModifiedAt(),
                boardDto.getCreatedBy(),
                boardTechStackDtos,
                boardPositionDtos);
    }

}

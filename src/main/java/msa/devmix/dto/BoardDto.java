package msa.devmix.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import msa.devmix.domain.board.Board;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardDto {

    private Long boardId;
    private String title;
    private String content;

    @Setter
    private UserDto userDto;

    private String location;
    private String imageUrl;
    private Long viewCount; //조회수
    private String projectPeriod; //프로젝트 진행기간
    private LocalDate recruitEndDate;
    private RecruitmentStatus recruitmentStatus;
    private LocalDateTime createdAt; //게시글 생성일자
    private LocalDateTime lastModifiedAt; //게시글 수정일자
    private String createdBy;


    public static BoardDto of(
            String title,
            String content,
            UserDto userDto,
            String location,
            String imageUrl,
            String projectPeriod,
            LocalDate recruitEndDate,
            RecruitmentStatus recruitmentStatus) {
        return new BoardDto(
                null,
                title,
                content,
                userDto,
                location,
                imageUrl,
                null,
                projectPeriod,
                recruitEndDate,
                recruitmentStatus,
                null,
                null,
                null);
    }

    public static BoardDto from(Board board) {
        String location = board.getLocation().toString();
        return BoardDto.of(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                UserDto.from(board.getUser()),
                Location.getLocation(location),
                board.getImageUrl(),
                board.getRecruitmentStatus(),
                board.getViewCount(),
                board.getProjectPeriod(),
                board.getRecruitEndDate(),
                board.getCreatedAt(),
                board.getLastModifiedAt(),
                board.getUser().getNickname()
        );
    }

    public static BoardDto of(Long boardId,
                              String title,
                              String content,
                              UserDto userDto,
                              String location,
                              String imageUrl,
                              RecruitmentStatus recruitmentStatus,
                              Long viewCount,
                              String projectPeriod,
                              LocalDate recruitEndDate,
                              LocalDateTime createdAt,
                              LocalDateTime lastModifiedAt,
                              String createdBy) {
        return new BoardDto(
                boardId,
                title,
                content,
                userDto,
                location,
                imageUrl,
                viewCount,
                projectPeriod,
                recruitEndDate,
                recruitmentStatus,
                createdAt,
                lastModifiedAt,
                createdBy);
    }

    public static BoardDto of(String title,
                              String content,
                              UserDto userDto,
                              String location,
                              String imageUrl,
                              String projectPeriod,
                              LocalDate recruitEndDate
                              ) {
        return new BoardDto(
                null,
                title,
                content,
                userDto,
                location,
                imageUrl,
                null,
                projectPeriod,
                recruitEndDate,
                null,
                null,
                null,
                null);
    }

    public Board toEntity() {
        return Board.of(
                title,
                content,
                imageUrl,
                Location.fromString(location),
                projectPeriod,
                recruitEndDate);


    }


}

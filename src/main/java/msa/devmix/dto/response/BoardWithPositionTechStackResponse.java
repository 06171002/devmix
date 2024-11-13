package msa.devmix.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;
import msa.devmix.dto.BoardWithPositionTechStackDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Data
@AllArgsConstructor
public class BoardWithPositionTechStackResponse {

    // 제목, 내용, 대표이미지, 작성자 닉네임, 모집상태, 모집구분, 포지션리스트, 지역, 프로젝트 진행기간, 기술스택, 댓글, 작성날짜, 조회수

    // 제목, 내용, 게시글 번호(ID), 모집상태, 조회수, 북마크 해간놈 boolean, 진행방식(지역), 기술스택 dto, 진행기간, 시작일, 모집마감일, 포지션 dto, 작성자정보 dto, BaseTimeEntity

    private String title;
    private String content;
    private Long boardId;
    private String imageUrl;
    private String location;
    private String recruitmentStatus;
    private Long viewCount;
    private String projectPeriod;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String nickname;
    private String username;
    private String profileImage;
    private String createdAt;
    private String lastModifiedAt;
    private String createdBy;

    //
    private List<BoardTechStackResponse> techStackDtoList;
    private List<BoardPositionResponse> positionDtoList;


    public static BoardWithPositionTechStackResponse from(BoardWithPositionTechStackDto dto) {



        return BoardWithPositionTechStackResponse.of(
                dto.getTitle(),
                dto.getContent(),
                dto.getBoardId(),
                dto.getImageUrl(),
                dto.getLocation(),
                RecruitmentStatus.getRecruitmentStatus(dto.getRecruitmentStatus().toString()),
                dto.getViewCount(),
                dto.getProjectPeriod(),
                dto.getEndDate(),
                dto.getUserDto().getNickname(),
                dto.getUserDto().getUsername(),
                dto.getUserDto().getProfileImage(),
                dto.getCreatedAt(),
                dto.getLastModifiedAt(),
                dto.getCreatedBy(),
                BoardTechStackResponse.from(dto.getBoardTechStackDtos()),
                BoardPositionResponse.from(dto.getBoardPositionDtos()));
    }

    public static BoardWithPositionTechStackResponse of(String title,
                                                        String content,
                                                        Long boardId,
                                                        String imageUrl,
                                                        String location,
                                                        String recruitmentStatus,
                                                        Long viewCount,
                                                        String projectPeriod,
                                                        LocalDate endDate,
                                                        String nickname,
                                                        String username,
                                                        String profileImage,
                                                        LocalDateTime createdAt,
                                                        LocalDateTime lastModifiedAt,
                                                        String createdBy,
                                                        List<BoardTechStackResponse> techStackResponseList,
                                                        List<BoardPositionResponse> positionResponseList) {

        String createdAtToString = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String lastModifiedAtToString = lastModifiedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new BoardWithPositionTechStackResponse(
                title,
                content,
                boardId,
                imageUrl,
                location,
                recruitmentStatus,
                viewCount,
                projectPeriod,
                endDate,
                nickname,
                username,
                profileImage,
                createdAtToString,
                lastModifiedAtToString,
                createdBy,
                techStackResponseList,
                positionResponseList);
    }
//    private String title;
//    private String content;
//    private Long boardId;
//    private String imageUrl;
//    private RecruitmentStatus recruitmentStatus;
//    private Long viewCount;
//    private boolean scrap;
//    private LocationV1 location;
//    private Long projectPeriod;
//    private LocalDateTime endDate;
//    private String userNickname;
//    private String username;
//    private String profileImage;
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;
//
//
//    private List<BoardTechStackDto> techStackDtoList;
//    private List<BoardPositionDto> positionDtoList;

}

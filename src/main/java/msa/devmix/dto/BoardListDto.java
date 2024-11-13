package msa.devmix.dto;

import lombok.Data;
import msa.devmix.dto.response.BoardPositionListResponseTest;
import msa.devmix.dto.response.BoardTechStackListResponseTest;

import java.time.LocalDate;
import java.util.List;

@Data
public class BoardListDto {

    private Long boardId;
    private String title;
    private String createdBy;
    private Long viewCount;
    private Long commentCount;
    private LocalDate recruitEndDate;

    private List<BoardPositionListResponseTest> positions;
    private List<BoardTechStackListResponseTest> techStacks;


}

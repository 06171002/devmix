package msa.devmix.repository.query;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BoardCommentQueryDto {

    private Long boardId;
    private String userNickName;
    private String content;
    private LocalDateTime createdAt;
}

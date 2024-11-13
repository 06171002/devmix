package msa.devmix.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.user.User;
import msa.devmix.dto.CommentDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentsResponse {

    private Long id;
    private Long boardId;//N:1
    private String boardTitle;
    private String userNickName;
    private String content;
    private String createdAt; //Auditing Fields
    private LocalDateTime lastModifiedAt; //Auditing Fields

    public static CommentsResponse of(Long id,
                                      Long boardId,
                                      String boardTitle,
                                      String userNickName,
                                      String content,
                                      String createdAt,
                                      LocalDateTime lastModifiedAt) {
        return new CommentsResponse(id, boardId, boardTitle, userNickName, content, createdAt, lastModifiedAt);
    }

    public static CommentsResponse from(CommentDto commentDto) {
        String createdAtString = commentDto.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return CommentsResponse.of(
                commentDto.getId(),
                commentDto.getBoardId(),
                commentDto.getBoardTitle(),
                commentDto.getUser().getNickname(),
                commentDto.getContent(),
                createdAtString,
                commentDto.getLastModifiedAt()
        );
    }
}

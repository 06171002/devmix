package msa.devmix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.board.Comment;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserCommentsDto {

    private String content;
    private LocalDateTime createdAt;

    public static UserCommentsDto from(Comment comment) {
        return new UserCommentsDto(comment.getContent(), comment.getCreatedAt());
    }
}

package msa.devmix.dto;


import lombok.Data;
import msa.devmix.domain.board.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CommentResponse {

    private Long id;
    private String nickname;
    private String profileImage;
    private String commentContent;
    private String createdAt;

    private CommentResponse(Long id, String nickname, String profileImage, String commentContent, String createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.commentContent = commentContent;
        this.createdAt = createdAt;
    }

    public static CommentResponse of(Long id, String nickname, String profileImage, String commentContent, String createdAt) {
        return new CommentResponse(id, nickname, profileImage, commentContent, createdAt);
    }

    public static CommentResponse from(CommentDto commentDto) {
        LocalDateTime createdAt = commentDto.getCreatedAt();
        String convertCreatedAtToString = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return CommentResponse.of(
                commentDto.getId(),
                commentDto.getUser().getNickname(),
                commentDto.getUser().getProfileImage(),
                commentDto.getContent(),
                convertCreatedAtToString
        );
    }
}

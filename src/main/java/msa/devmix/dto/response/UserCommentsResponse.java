package msa.devmix.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.dto.UserCommentsDto;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class UserCommentsResponse {

    private String content;
    private String createdAt;

    public static UserCommentsResponse from(UserCommentsDto userCommentsDto) {
        String createdAtToString = userCommentsDto.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return new UserCommentsResponse(
                userCommentsDto.getContent(),
                createdAtToString
        );
    }
}

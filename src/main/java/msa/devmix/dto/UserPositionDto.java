package msa.devmix.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.user.UserPosition;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPositionDto {

    private String positionName;

    public static UserPositionDto of(String positionName) {
        return new UserPositionDto(positionName);
    }

    public static UserPositionDto from(UserPosition userPosition) {
        return UserPositionDto.of(userPosition.getPosition().getPositionNameKorean());
    }
}

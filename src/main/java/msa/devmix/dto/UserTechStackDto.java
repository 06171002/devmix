package msa.devmix.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.user.UserTechStack;
import org.springframework.scheduling.config.ScheduledTask;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTechStackDto {

    private String techStackName;
    private String techStackImageUrl;

    public static UserTechStackDto of(String techStackName, String techStackImageUrl) {
        return new UserTechStackDto(techStackName, techStackImageUrl);
    }

    public static UserTechStackDto from(UserTechStack userTechStack) {
        return UserTechStackDto.of(
                userTechStack.getTechStack().getTechStackName(),
                userTechStack.getTechStack().getImageUrl());
    }
}

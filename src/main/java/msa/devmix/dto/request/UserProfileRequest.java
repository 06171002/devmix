package msa.devmix.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import msa.devmix.domain.user.User;
import msa.devmix.dto.TechStackDto;
import msa.devmix.dto.UserWithPositionTechStackDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserProfileRequest {

    @NotBlank(message = "Nickname cannot be blank")
    @Size(min = 2, max = 8, message = "Nickname must be between 2 and 8 characters")
    @Pattern(regexp = "^[a-zA-Z0-9가-힣]*$", message = "Nickname can only contain alphanumeric characters and no spaces")
    private String nickname;
    private String email;
    private String groupName;
    private String location;
    private List<String> positionList;
    private List<String> techStackList;


    public UserWithPositionTechStackDto toDto(User user) {

        List<TechStackDto> techStackDtos = new ArrayList<>();
        if (techStackList != null) {
            techStackDtos = techStackList.stream()
                    .map(TechStackDto::of)
                    .toList();
        }

        return UserWithPositionTechStackDto.of(user, nickname, email, groupName, location, positionList, techStackDtos);
    }
}

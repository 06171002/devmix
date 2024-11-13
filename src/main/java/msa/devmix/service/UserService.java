package msa.devmix.service;

import msa.devmix.domain.user.User;
import msa.devmix.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User findById(Long userId);
    User findByUsername(String username);
    UserWithPositionTechStackDto getUserInfo(Long userId);
    UserDto getSignInUserInfo(Long userId);
    void checkNickname(String nickname);
    void saveUserProfile(UserWithPositionTechStackDto userWithPositionTechStackDto, MultipartFile profileImage) throws IOException;

    List<UserBoardsDto> findUserBoards(Long userId, Pageable pageable);
    List<CommentDto> findUserComments(Long userId, Pageable pageable);


}

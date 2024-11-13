package msa.devmix.repository;

import msa.devmix.domain.user.User;
import msa.devmix.domain.user.UserPosition;
import msa.devmix.dto.UserPositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPositionRepository extends JpaRepository<UserPosition, Long> {

    //N+1 문제 해결 O => 페치조인은 연관된 데이터를 같이 끌고올 때 유용하므로 일반 조인 사용
    @Query("SELECT p.positionName" +
            " FROM UserPosition up" +
            " JOIN up.position p" +
            " WHERE up.user = :user")
    List<String> findWithPositionByUser(User user);

    @Query("SELECT new msa.devmix.dto.UserPositionDto(p.positionNameKorean) " +
            "FROM UserPosition up " +
            "JOIN up.position p " +
            "WHERE up.user.id = :userId")
    List<UserPositionDto> findWithPositionByUserId(@Param("userId") Long userId);
}
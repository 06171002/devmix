package msa.devmix.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.dto.request.AdmitRequest;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdmitDto {

    private Long boardPositionId; // 승인 요청하는 보드포지션 ID
    private Long userId; // 승인 요청하는 지원자 ID
    private String positionName; // 승인 요청하는 포지션이름

    public static AdmitDto of(Long boardPositionId, Long userId, String positionName) {
        return new AdmitDto(boardPositionId, userId, positionName);
    }

    public static AdmitDto from(AdmitRequest admitRequest) {
        return AdmitDto.of(admitRequest.getBoardPositionId(), admitRequest.getUserId(), admitRequest.getPositionName());
    }
}

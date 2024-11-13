package msa.devmix.dto.request;

import lombok.Data;

@Data
public class AdmitRequest {

    private Long boardPositionId; // 승인 요청하는 보드포지션 ID
    private Long userId; // 승인 요청하는 지원자 ID
    private String positionName; // 승인 요청하는 포지션이름
}

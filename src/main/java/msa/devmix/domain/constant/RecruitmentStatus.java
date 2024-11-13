package msa.devmix.domain.constant;

import lombok.Getter;

@Getter
public enum RecruitmentStatus {
    RECRUITING("모집중"), COMPLETED("모집완료"); //모집중, 모집완료


    private final String recruitmentStatus;

    RecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    public static String getRecruitmentStatus(String recruitmentStatus) {
        return RecruitmentStatus.valueOf(recruitmentStatus).getRecruitmentStatus();
    }

    public static RecruitmentStatus getRecruitmentStatusFromString(String recruitmentStatus) {
        for (RecruitmentStatus status : RecruitmentStatus.values()) {
            if (status.getRecruitmentStatus().equals(recruitmentStatus)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown recruitment status: " + recruitmentStatus);
    }
}

package msa.devmix.service;

import msa.devmix.domain.user.User;
import msa.devmix.dto.AdmitDto;
import msa.devmix.dto.ApplyDto;

public interface ApplyService {
    void saveApply(ApplyDto applyDto);

    void admitUser(AdmitDto admitDto, Long userId);
}

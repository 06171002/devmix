package msa.devmix.service;

import msa.devmix.dto.TechStackDto;

import java.util.List;

public interface TechStackService {

    List<TechStackDto> getTechStacks();

    List<TechStackDto> getFrontTechStacks(String frontEnd);
    List<TechStackDto> getBackTechStacks(String backEnd);
}

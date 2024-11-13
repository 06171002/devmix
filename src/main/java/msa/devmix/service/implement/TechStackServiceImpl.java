package msa.devmix.service.implement;

import lombok.RequiredArgsConstructor;
import msa.devmix.domain.common.TechStack;
import msa.devmix.dto.TechStackDto;
import msa.devmix.repository.TechStackRepository;
import msa.devmix.service.TechStackService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TechStackServiceImpl implements TechStackService {

    private final TechStackRepository techStackRepository;

    @Override
    public List<TechStackDto> getTechStacks() {

        List<TechStack> techStacks = techStackRepository.findAll();

        List<TechStackDto> techStackDtos = techStacks.stream()
                .map(TechStackDto::from)
                .toList();

        return techStackDtos;
    }

    @Override
    public List<TechStackDto> getFrontTechStacks(String frontEnd) {
        List<TechStack> techStacks = techStackRepository.findByTechStackCategory(frontEnd);

        return techStacks.stream().map(TechStackDto::from).toList();
    }

    @Override
    public List<TechStackDto> getBackTechStacks(String backEnd) {
        List<TechStack> techStacks = techStackRepository.findByTechStackCategory(backEnd);

        return techStacks.stream().map(TechStackDto::from).toList();
    }


}

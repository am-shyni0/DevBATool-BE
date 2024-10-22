package com.devBA.devBATool.Service;

import com.devBA.devBATool.Dto.ASprintDto;
import com.devBA.devBATool.Model.ASprintModel;
import com.devBA.devBATool.Repository.ASprintRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ASprintServiceImpl implements ASprintService{

    @Autowired
    private ASprintRepository aSprintRepository;

    @Override
    public ASprintModel createASprint(ASprintDto aSprintDto) {
        ASprintModel asprint = new ASprintModel();

        asprint.setProjectName(aSprintDto.getProjectName());
        asprint.setIssueType(aSprintDto.getIssueType());
        asprint.setStatus(aSprintDto.getStatus());
        asprint.setEpicName(aSprintDto.getEpicName());

        return aSprintRepository.save(asprint);
    }

    @Override
    public ASprintModel getASprintById(Integer id) {
        return aSprintRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    @Override
    public List<ASprintModel> getAllASprints() {
        return aSprintRepository.findAll();
    }

    @Override
    public ASprintModel updateASprint(Integer id, ASprintDto aSprintDto) {
        ASprintModel asprint = getASprintById(id);

        if (aSprintDto.getProjectName() != null) {
            asprint.setProjectName(aSprintDto.getProjectName());
        }
        if (aSprintDto.getIssueType() != null) {
            asprint.setIssueType(aSprintDto.getIssueType());
        }
        if (aSprintDto.getStatus() != null) {
            asprint.setStatus(aSprintDto.getStatus());
        }
        if (aSprintDto.getEpicName() != null) {
            asprint.setEpicName(aSprintDto.getEpicName());
        }

        return aSprintRepository.save(asprint);
    }

    @Override
    public void deleteASprint(Integer id) {
        if (!aSprintRepository.existsById(id)) {
            throw new EntityNotFoundException("Item not found with id: " + id);
        }
        aSprintRepository.deleteById(id);
    }
}

package com.devBA.devBATool.Service;

import com.devBA.devBATool.Dto.BacklogDto;
import com.devBA.devBATool.Model.BacklogModel;
import com.devBA.devBATool.Repository.BacklogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImpl implements BacklogService{
    @Autowired
    private BacklogRepository backlogRepository;

    @Override
    public BacklogModel createBacklog(BacklogDto backlogDto) {
        BacklogModel backlog = new BacklogModel();

        backlog.setProjectName(backlogDto.getProjectName());
        backlog.setIssueType(backlogDto.getIssueType());
        backlog.setStatus(backlogDto.getStatus());
        backlog.setEpicName(backlogDto.getEpicName());

        return backlogRepository.save(backlog);
    }

    @Override
    public BacklogModel getBacklogById(Integer id) {
        return backlogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("backlog not found with id: " + id));
    }

    @Override
    public List<BacklogModel> getAllBacklogs() {
        return backlogRepository.findAll();
    }

    @Override
    public BacklogModel updateBacklog(Integer id, BacklogDto backlogDto) {
        BacklogModel backlog = getBacklogById(id);

        if (backlogDto.getProjectName() != null) {
            backlog.setProjectName(backlogDto.getProjectName());
        }
        if (backlogDto.getIssueType() != null) {
            backlog.setIssueType(backlogDto.getIssueType());
        }
        if (backlogDto.getStatus() != null) {
            backlog.setStatus(backlogDto.getStatus());
        }
        if (backlogDto.getEpicName() != null) {
            backlog.setEpicName(backlogDto.getEpicName());
        }

        return backlogRepository.save(backlog);
    }

    @Override
    public void deleteBacklog(Integer id) {
        if (!backlogRepository.existsById(id)) {
            throw new EntityNotFoundException("Backlog not found with id: " + id);
        }
        backlogRepository.deleteById(id);
    }
}

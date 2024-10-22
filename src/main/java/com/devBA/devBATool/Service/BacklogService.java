package com.devBA.devBATool.Service;
import com.devBA.devBATool.Dto.BacklogDto;
import com.devBA.devBATool.Model.BacklogModel;
import java.util.List;

public interface BacklogService {
    BacklogModel createBacklog(BacklogDto backlogDto);
    BacklogModel getBacklogById(Integer id);
    List<BacklogModel> getAllBacklogs();
    BacklogModel updateBacklog(Integer id, BacklogDto backlogDto);
    void deleteBacklog(Integer id);
}

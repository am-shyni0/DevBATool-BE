package com.devBA.devBATool.Service;
import com.devBA.devBATool.Model.ASprintModel;
import com.devBA.devBATool.Dto.ASprintDto;


import java.util.List;

public interface ASprintService {
    ASprintModel createASprint(ASprintDto aSprintDto);
    ASprintModel getASprintById(Integer id);
    List<ASprintModel> getAllASprints();
    ASprintModel updateASprint(Integer id, ASprintDto aSprintDto);
    void deleteASprint(Integer id);
}

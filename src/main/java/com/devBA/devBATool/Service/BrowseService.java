package com.devBA.devBATool.Service;
import com.devBA.devBATool.Dto.BrowseDto;
import com.devBA.devBATool.Model.BrowseModel;
import java.util.List;
public interface BrowseService {
    BrowseModel createBrowse(BrowseDto browseDto);
    BrowseModel getBrowseById(Integer id);
    List<BrowseModel> getAllBrowses();
    BrowseModel updateBrowse(Integer id, BrowseDto browseDto);
    void deleteBrowse(Integer id);
}

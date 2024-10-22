package com.devBA.devBATool.Service;
import com.devBA.devBATool.Dto.BrowseDto;
import com.devBA.devBATool.Model.BrowseModel;
import com.devBA.devBATool.Repository.BrowseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService  {
    @Autowired
    private BrowseRepository browseRepository;

    @Override
    public BrowseModel createBrowse(BrowseDto browseDto) {
        BrowseModel browse = new BrowseModel();

        browse.setFileName(browseDto.getFileName());

        return browseRepository.save(browse);
    }

    @Override
    public BrowseModel getBrowseById(Integer id) {
        return browseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("File not found with id: " + id));
    }

    @Override
    public List<BrowseModel> getAllBrowses() {
        return browseRepository.findAll();
    }

    @Override
    public BrowseModel updateBrowse(Integer id, BrowseDto browseDto) {
        BrowseModel browse = getBrowseById(id);

        if (browseDto.getFileName() != null) {
            browse.setFileName(browseDto.getFileName());
        }

        return browseRepository.save(browse);
    }

    @Override
    public void deleteBrowse(Integer id) {
        if (!browseRepository.existsById(id)) {
            throw new EntityNotFoundException("File not found with id: " + id);
        }
        browseRepository.deleteById(id);
    }
}

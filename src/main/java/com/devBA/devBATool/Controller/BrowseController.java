package com.devBA.devBATool.Controller;
import com.devBA.devBATool.Dto.BrowseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devBA.devBATool.Model.BrowseModel;
import com.devBA.devBATool.Service.BrowseService;
import com.devBA.devBATool.Service.BrowseServiceImpl;
import com.devBA.devBATool.Repository.BrowseRepository;
import java.util.List;

@RestController

public class BrowseController {
    @Autowired
    private BrowseService browseService;

    @PostMapping ("/browseCreate")
    public ResponseEntity<BrowseModel> createBrowse(@RequestBody BrowseDto browseDto) {
        BrowseModel newBrowse = browseService.createBrowse(browseDto);
        return new ResponseEntity<>(newBrowse, HttpStatus.CREATED);
    }

    @GetMapping("/browseCreate/{id}")
    public ResponseEntity<BrowseModel> getBrowse(@PathVariable Integer id) {
        BrowseModel browse = browseService.getBrowseById(id);
        return ResponseEntity.ok(browse);
    }

    @GetMapping("/browseCreate")
    public ResponseEntity<List<BrowseModel>> getAllBrowses() {
        List<BrowseModel> browses = browseService.getAllBrowses();
        return ResponseEntity.ok(browses);
    }

    @PutMapping("/browseCreate/{id}")
    public ResponseEntity<BrowseModel> updateBrowse(@PathVariable Integer id, @RequestBody BrowseDto browseDto) {
        BrowseModel updateBrowse = browseService.updateBrowse(id, browseDto);
        return ResponseEntity.ok(updateBrowse);
    }

    @DeleteMapping("/browseCreate/{id}")
    public ResponseEntity<?> deleteBrowse(@PathVariable Integer id) {
        browseService.deleteBrowse(id);
        return ResponseEntity.ok("Document deleted successfully");
    }
}

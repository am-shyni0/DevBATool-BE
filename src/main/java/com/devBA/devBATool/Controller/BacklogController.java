package com.devBA.devBATool.Controller;
import com.devBA.devBATool.Dto.BacklogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devBA.devBATool.Model.BacklogModel;
import com.devBA.devBATool.Service.BacklogService;
import com.devBA.devBATool.Service.BacklogServiceImpl;
import com.devBA.devBATool.Repository.BacklogRepository;
import java.util.List;

@RestController
public class BacklogController {
    @Autowired
    private BacklogService backlogService;

    @PostMapping ("/backlogCreate")
    public ResponseEntity<BacklogModel> createBacklog(@RequestBody BacklogDto backlogDto) {
        BacklogModel newBacklog = backlogService.createBacklog(backlogDto);
        return new ResponseEntity<>(newBacklog, HttpStatus.CREATED);
    }

    @GetMapping("/backlogCreate/{id}")
    public ResponseEntity<BacklogModel> getBacklog(@PathVariable Integer id) {
        BacklogModel backlog = backlogService.getBacklogById(id);
        return ResponseEntity.ok(backlog);
    }

    @GetMapping("/backlogCreate")
    public ResponseEntity<List<BacklogModel>> getAllBacklogs() {
        List<BacklogModel> backlogs = backlogService.getAllBacklogs();
        return ResponseEntity.ok(backlogs);
    }

    @PutMapping("/backlogCreate/{id}")
    public ResponseEntity<BacklogModel> updateBacklog(@PathVariable Integer id, @RequestBody BacklogDto backlogDto) {
        BacklogModel updatedBacklog = backlogService.updateBacklog(id, backlogDto);
        return ResponseEntity.ok(updatedBacklog);
    }

    @DeleteMapping("/backlogCreate/{id}")
    public ResponseEntity<?> deleteBacklog(@PathVariable Integer id) {
        backlogService.deleteBacklog(id);
        return ResponseEntity.ok("Backlog deleted successfully");
    }
}

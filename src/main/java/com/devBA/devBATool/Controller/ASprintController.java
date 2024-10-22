package com.devBA.devBATool.Controller;
import com.devBA.devBATool.Dto.ASprintDto;
import com.devBA.devBATool.Model.ASprintModel;
import com.devBA.devBATool.Service.ASprintService;
import com.devBA.devBATool.Service.ASprintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ASprintController {
    @Autowired
    private ASprintService aSprintService;

    @PostMapping ("/ASprintCreate")
    public ResponseEntity<ASprintModel> createASprintModel(@RequestBody ASprintDto aSprintDto) {
        ASprintModel newASprint = aSprintService.createASprint(aSprintDto);
        return new ResponseEntity<>(newASprint, HttpStatus.CREATED);
    }
}

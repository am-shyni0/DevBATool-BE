package com.devBA.devBATool.Controller;
import com.devBA.devBATool.Dto.CalendarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devBA.devBATool.Model.CalendarModel;
import com.devBA.devBATool.Service.CalendarService;
import com.devBA.devBATool.Service.CalendarServiceImpl;
import com.devBA.devBATool.Repository.CalendarRepository;
import java.util.List;

@RestController
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping ("/calendarCreate")
    public ResponseEntity<CalendarModel> createCalendar(@RequestBody CalendarDto calendarDto) {
        CalendarModel newCalendar = calendarService.createCalendar(calendarDto);
        return new ResponseEntity<>(newCalendar, HttpStatus.CREATED);
    }

    @GetMapping("/calendarCreate/{id}")
    public ResponseEntity<CalendarModel> getCalendar(@PathVariable Integer id) {
        CalendarModel calendar = calendarService.getCalendarById(id);
        return ResponseEntity.ok(calendar);
    }

    @GetMapping("/calendarCreate")
    public ResponseEntity<List<CalendarModel>> getAllCalendars() {
        List<CalendarModel> calendars = calendarService.getAllCalendars();
        return ResponseEntity.ok(calendars);
    }

    @PutMapping("/calendarCreate/{id}")
    public ResponseEntity<CalendarModel> updateCalendar(@PathVariable Integer id, @RequestBody CalendarDto calendarDto) {
        CalendarModel updatedCalendar = calendarService.updateCalendar(id, calendarDto);
        return ResponseEntity.ok(updatedCalendar);
    }

    @DeleteMapping("/calendarCreate/{id}")
    public ResponseEntity<?> deleteCalendar(@PathVariable Integer id) {
        calendarService.deleteCalendar(id);
        return ResponseEntity.ok("Calendar deleted successfully");
    }
}

// Test Comment

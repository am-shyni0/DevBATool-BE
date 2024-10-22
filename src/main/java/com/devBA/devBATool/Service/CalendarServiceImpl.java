package com.devBA.devBATool.Service;

import com.devBA.devBATool.Dto.BacklogDto;
import com.devBA.devBATool.Dto.CalendarDto;
import com.devBA.devBATool.Model.BacklogModel;
import com.devBA.devBATool.Model.CalendarModel;
import com.devBA.devBATool.Repository.CalendarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService{
    @Autowired
    private CalendarRepository calendarRepository;

    @Override
    public CalendarModel createCalendar(CalendarDto calendarDto) {
        CalendarModel calendar = new CalendarModel();

        calendar.setMeetingName(calendarDto.getMeetingName());
        calendar.setDate(calendarDto.getDate());
        calendar.setTime(calendarDto.getTime());
        calendar.setAddDescription(calendarDto.getAddDescription());

        return calendarRepository.save(calendar);
    }

    @Override
    public CalendarModel getCalendarById(Integer id) {
        return calendarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("calendar not found with id: " + id));
    }

    @Override
    public List<CalendarModel> getAllCalendars() {
        return calendarRepository.findAll();
    }

    @Override
    public CalendarModel updateCalendar(Integer id, CalendarDto calendarDto) {
        CalendarModel calendar = getCalendarById(id);

        if (calendarDto.getMeetingName() != null) {
            calendar.setMeetingName(calendarDto.getMeetingName());
        }
        if (calendarDto.getDate() != null) {
            calendar.setDate(calendarDto.getDate());
        }
        if (calendarDto.getTime() != null) {
            calendar.setTime(calendarDto.getTime());
        }
        if (calendarDto.getAddDescription() != null) {
            calendar.setAddDescription(calendarDto.getAddDescription());
        }

        return calendarRepository.save(calendar);
    }

    @Override
    public void deleteCalendar(Integer id) {
        if (!calendarRepository.existsById(id)) {
            throw new EntityNotFoundException("calendar not found with id: " + id);
        }
        calendarRepository.deleteById(id);
    }
}

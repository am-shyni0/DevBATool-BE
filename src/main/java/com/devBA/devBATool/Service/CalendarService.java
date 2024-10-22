package com.devBA.devBATool.Service;
import com.devBA.devBATool.Dto.CalendarDto;
import com.devBA.devBATool.Model.CalendarModel;
import java.util.List;

public interface CalendarService {
    CalendarModel createCalendar(CalendarDto calendarDto);
    CalendarModel getCalendarById(Integer id);
    List<CalendarModel> getAllCalendars();
    CalendarModel updateCalendar(Integer id, CalendarDto calendarDto);
    void deleteCalendar(Integer id);
}

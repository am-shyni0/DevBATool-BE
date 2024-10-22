package com.devBA.devBATool.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendar_info")
public class CalendarModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarId;
    private String meetingName;
    private  String date;
    private  String time;
    private String addDescription;
    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }

}

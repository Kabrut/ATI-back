package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Events {
    @Id
    @GeneratedValue
    private int event_id;
    private String event_title;
    private String event_header;
    private String event_content;
    private String event_date;

    public Events() {
    }

    public Events(String event_title, String event_header, String event_content, String event_date) {
        this.event_title = event_title;
        this.event_header = event_header;
        this.event_content = event_content;
        this.event_date = event_date;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_header() {
        return event_header;
    }

    public void setEvent_header(String event_header) {
        this.event_header = event_header;
    }

    public String getEvent_content() {
        return event_content;
    }

    public void setEvent_content(String event_content) {
        this.event_content = event_content;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }
}

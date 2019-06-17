package com.example.demo.controllers;

import com.example.demo.model.Events;
import com.example.demo.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EventsController {

    @Autowired
    EventsRepository eventsRepository;


    @RequestMapping(path = "/event", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addEvent(@RequestParam String event_title, @RequestParam String event_content, @RequestParam String event_header, @RequestParam String event_date ) {
        Events event = new Events(event_title, event_content, event_header, event_date);
        eventsRepository.save(event);
        return String.valueOf(event.getEvent_id());
    }

    @GetMapping("/showEvent")
    public List<Events> getAllEvents(){
        Iterable<Events> event = eventsRepository.findAll();
        return (ArrayList<Events>) event;
    }
}

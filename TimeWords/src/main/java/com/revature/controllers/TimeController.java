package com.revature.controllers;

import com.revature.models.Event;
import com.revature.models.EventDTO;
import com.revature.models.Time;
import com.revature.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/events")
public class TimeController {

    private TimeService timeService;

    @Autowired
    public TimeController(TimeService service) {
        this.timeService = service;
    }

    @GetMapping
    public List<EventDTO> getAllEvents() {
        return timeService.getAllEventsTimeInWords();
    }

    @PostMapping(value="/gettime")
    public String getTimeInWords(@Valid @RequestBody Time time) {
       return timeService.getTimeInWords(time);
    }

    @PostMapping
    public Event registerNewEvent(@Valid @RequestBody Event newEvent) {
        return timeService.registerNewEvent(newEvent);
    }

}

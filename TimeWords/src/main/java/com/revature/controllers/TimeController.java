package com.revature.controllers;

import com.revature.models.Event;
import com.revature.models.EventDTO;
import com.revature.models.Time;
import com.revature.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public Time getTimeInWords(@Valid @RequestBody Time time) {
        Time thisTime = new Time(timeService.getTimeInWords(time));
       return thisTime;
    }

    @PostMapping
    public Event registerNewEvent(@Valid @RequestBody EventDTO newEvent) throws ParseException {
        System.out.println(newEvent);
        return timeService.registerNewEvent(newEvent);
    }

}

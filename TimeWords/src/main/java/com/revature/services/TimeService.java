package com.revature.services;

import antlr.ASTNULLType;
import com.revature.models.Event;
import com.revature.models.EventDTO;
import com.revature.models.Time;
import com.revature.repositories.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class TimeService {

    private TimeRepo timeRepo;

    @Autowired
    public TimeService(TimeRepo repo) {
        this.timeRepo = repo;
    }

    @Transactional
    public List<EventDTO> getAllEventsTimeInWords() {

        List<Event> events = (List<Event>) timeRepo.findAll();
        List<EventDTO> stringEvents = new ArrayList<>();

        for(Event event : events) {
            LocalTime thisTime = event.getTime();
            int thisHour = thisTime.getHour();
            int thisMinute = thisTime.getMinute();
            String thisStringTime = timeInWords(thisHour, thisMinute);
            EventDTO eventDTO = new EventDTO(event.getId(), event.getName(), event.getLocation(), thisStringTime);
            stringEvents.add(eventDTO);
        }

        return stringEvents;
    }

    public Event registerNewEvent(Event newEvent) {
        return timeRepo.save(newEvent);
    }

    public String getTimeInWords(Time time) {
        String[] arrOfStr = time.getTime().split(":");
        return timeInWords(parseInt(arrOfStr[0]), parseInt(arrOfStr[1]));
    }

    static String timeInWords(int h, int m) {
        String message = "";
        String hour = "";
        int minutes = 0;
        String minute = "";
        String qualifier = "";

        if (m > 30) {
            minutes = (60 - m);
            qualifier = " to ";
            h++;

        } else if (m < 30) {
            qualifier = " past ";
            minutes = m;
        } else {
            qualifier =  ("half past");
        }


        if (h == 1) {
            hour = "one";;
        } else if (h == 2) {
            hour = "two";
        } else if (h == 3) {
            hour = "three";
        } else if (h == 4) {
            hour = "four";
        } else if (h == 5) {
            hour = "five";
        } else if (h == 6) {
            hour = "six";
        }else if (h ==7) {
            hour = "seven";
        }else if (h == 8) {
            hour = "eight";
        }else if (h == 9) {
            hour = "nine";
        }else if (h == 10) {
            hour = "ten";
        }else if (h == 11) {
            hour = "eleven";
        }else if (h == 12) {
            hour = "twelve";
        }

        if (m == 30) {
            return (qualifier + " " + hour);
        }

        if (minutes == 0) {
            return (hour + " o' clock");
        }else if (minutes == 0 && m == 30) {
            return (qualifier + hour) ;
        }else if (minutes == 1) {
            minute = ("one minute" );
        } else if (minutes == 2) {
            minute = ("two minutes");
        } else if (minutes == 3) {
            minute = ("three minutes" );
        } else if (minutes == 4) {
            minute = ("four minutes");
        } else if (minutes == 5) {
            minute = ("five minutes");
        } else if (minutes == 6) {
            minute = ("six minutes" );
        } else if (minutes == 7) {
            minute = ("seven minutes");
        } else if (minutes == 8) {
            minute = ("eight minutes" );
        } else if (minutes == 9) {
            minute = ("nine minutes" );
        } else if (minutes == 10) {
            minute = ("ten minutes" );
        } else if (minutes == 11) {
            minute = ("eleven minutes");
        } else if (minutes == 12) {
            minute = ("twelve minutes" );
        } else if (minutes == 13) {
            System.out.println("hi");
            minute = ("thirteen minutes" );
        } else if (minutes == 14) {
            minute = ("fourteen minutes" );
        } else if (minutes == 15) {
            minute = ("quarter");
        } else if (minutes == 16) {
            minute = ("sixteen minute" );
        } else if (minutes == 17) {
            minute = ("seventeen minutes");
        } else if (minutes == 18) {
            minute = ("eighteen minutes" );
        } else if (minutes == 19) {
            minute = ("nineteen minutes");
        } else if (minutes == 20) {
            minute = ("twenty minutes");
        } else if (minutes == 21) {
            minute = ("twenty one minutes" );
        } else if (minutes == 22) {
            minute = ("twenty two minutes");
        } else if (minutes == 23) {
            minute = ("twenty three minutes" );
        } else if (minutes == 24) {
            minute = ("twenty four minutes" );
        } else if (minutes == 25) {
            minute = ("twenty five minutes" );
        } else if (minutes == 26) {
            minute = ("twenty six minutes");
        } else if (minutes == 27) {
            minute = ("twenty seven minutes" );
        } else if (minutes == 28) {
            minute = ("twenty eight minutes" );
        } else if (minutes == 29) {
            minute = ("twenty nine minutes" );
        }




        return  (minute + qualifier + hour) ;


    }
}

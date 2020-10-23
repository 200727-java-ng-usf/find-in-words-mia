package com.revature.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Event {


    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String location;

    @Column(nullable=false)
    private LocalTime time;




    public Event() {

    }

    public Event(EventDTO event) throws ParseException {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm", Locale.US);

        this.name = event.getName();
        this.location = event.getLocation();
        LocalTime localTime = LocalTime.parse(event.getTime(), formatter);
        this.time = localTime;
    }

    public Event(int id, String name, String location, LocalTime time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(location, event.location) &&
                Objects.equals(time, event.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, time);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}

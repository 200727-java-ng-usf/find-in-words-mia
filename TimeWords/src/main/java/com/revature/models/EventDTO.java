package com.revature.models;


import java.time.LocalTime;
import java.util.Objects;

public class EventDTO {

    private String name;

    private String location;

    private String time;

    public EventDTO() {
    }

    public EventDTO(int id, String name, String location, String time) {
        this.name = name;
        this.location = location;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Objects.equals(name, eventDTO.name) &&
                Objects.equals(location, eventDTO.location) &&
                Objects.equals(time, eventDTO.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, time);
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

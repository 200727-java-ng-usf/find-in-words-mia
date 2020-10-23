package com.revature.models;

import java.util.Objects;

public class Time {

    private String time;

    public Time() {
    }

    public Time(String time) {
        this.time = time;
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
        Time time1 = (Time) o;
        return Objects.equals(time, time1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    @Override
    public String toString() {
        return "Time{" +
                "time='" + time + '\'' +
                '}';
    }
}

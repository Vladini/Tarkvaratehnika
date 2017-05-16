package com.example.user.traveleasy;

/**
 * Created by Vlad on 25.04.2017.
 */

public class Event {
    private int id;
    private String date;
    private String text;
    private String time;

    public Event(int id, String date, String text, String time) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.time = time;
    }

    public Event() {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

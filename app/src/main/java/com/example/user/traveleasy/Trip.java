package com.example.user.traveleasy;


/**
 * Created by Vlad on 14.03.2017.
 */

public class Trip {
    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private double overallBudget;
    private double hotelExpenses;
    private double ticketsExpenses;
    private String notes;
    private double otherExpenses;

    public Trip()
    {
    }
    public Trip(int id, String name, String startDate, String endDate, double overallBudget, double hotelExpenses, double ticketsExpenses, String notes, double otherExpenses)
    {
        this.id=id;
        this.name=name;
        this.startDate=startDate;
        this.endDate=endDate;
        this.overallBudget=overallBudget;
        this.hotelExpenses=hotelExpenses;
        this.ticketsExpenses=ticketsExpenses;
        this.notes=notes;
        this.otherExpenses=otherExpenses;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", overallBudget=" + overallBudget +
                ", hotelExpenses=" + hotelExpenses +
                ", ticketsExpenses=" + ticketsExpenses +
                ", notes=" + notes +
                ", otherExpenses=" + otherExpenses +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(double otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public int getId() {
        return id;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getName() {
        return name;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public double getOverallBudget() {
        return overallBudget;
    }
    public void setOverallBudget(double overallBudget) {
        this.overallBudget = overallBudget;
    }
    public double getHotelExpenses() {
        return hotelExpenses;
    }
    public void setHotelExpenses(double hotelExpenses) {
        this.hotelExpenses = hotelExpenses;
    }
    public double getTicketsExpenses() {
        return ticketsExpenses;
    }
    public void setTicketsExpenses(double ticketsExpenses) {
        this.ticketsExpenses = ticketsExpenses;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

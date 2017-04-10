package com.example.user.traveleasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showTrips(View view) {
        Intent intent = new Intent(this, RecentTripsActivity.class);
        startActivity(intent);
    }


    public void addTrip(View view) {
        Intent intent = new Intent(this, NewTripActivity.class);
        startActivity(intent);
//        DBHandler db = new DBHandler(this);
//
//// Inserting Shop/Rows
//        Log.d("Insert: ", "Inserting ..");
//        db.addTrip(new Trip(1, "Barcelona", "12.05.1998", "19.06.2017", 4500.99, 666.78, 550));
////        db.addTrip(new Trip(2, "Dunkin Donuts", "White Plains, NY 10601"));
////        db.addTrip(new Trip(3, "Pizza Porlar", "North West Avenue, Boston , USA"));
////        db.addTrip(new Trip(4, "Town Bakers", "Beverly Hills, CA 90210, USA"));
    }

    public void activeTrips(View view) {
        Intent intent = new Intent(this, ActiveTripsActivity.class);
        startActivity(intent);
//        DBHandler db = new DBHandler(this);
////        Log.d("Reading: ", "Reading all trips..");
//        List<Trip> trips = db.getAllTrips();
//
//        for (Trip trip : trips) {
//            String log = "Id: " + trip.getId() + " ,Name: " + trip.getName() + " ,Start Date: " + trip.getStartDate() + " ,End Date: " + trip.getEndDate() + " ,Budget: " + trip.getOverallBudget() + " ,Hotel Expenses: " + trip.getHotelExpenses() + " ,Tickets Expenses: " + trip.getTicketsExpenses();
//            Log.d("Trip: : ", log);
//        }
//        Log.d("Reading: ", String.valueOf(db.getTrip(5)));
//        DBHandler db = new DBHandler(this);
////        Log.d("Reading: ", "Reading all trips..");
//        List<Trip> trips = db.getAllTrips();
//
//        for (Trip trip : trips) {
//           db.deleteTrip(trip);
//            }
    }

    public void showActiveTrips(View view) {
        Intent intent = new Intent(this, ActiveTripsActivity.class);
        startActivity(intent);
    }
}



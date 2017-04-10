package com.example.user.traveleasy;


        import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Vlad on 14.03.2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "tripsInfo";
    // Contacts table name
    private static final String TABLE_TRIPS = "trips";
    // Trips Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_START_DATE = "trip_start_date";
    private static final String KEY_END_DATE = "trip_end_date";
    private static final String KEY_BUDGET = "trip_budget";
    private static final String KEY_HOTEL_EXPENSES = "trip_hotel_expenses";
    private static final String KEY_TICKETS_EXPENSES = "trip_tickets_expenses";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TRIPS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_START_DATE + " TEXT," + KEY_END_DATE + " TEXT," + KEY_BUDGET + " NUMBER," + KEY_HOTEL_EXPENSES + " NUMBER," + KEY_TICKETS_EXPENSES + " NUMBER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIPS);
// Creating tables again
        onCreate(db);
    }
    // Adding new trip
    public void addTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, trip.getName()); // Trip Name
        values.put(KEY_START_DATE, trip.getStartDate()); // Trip Starting Date
        values.put(KEY_END_DATE, trip.getEndDate()); // Trip Ending Date
        values.put(KEY_BUDGET, trip.getOverallBudget()); // Trip Budget
        values.put(KEY_HOTEL_EXPENSES, trip.getHotelExpenses()); // Trip Hotel Expenses
        values.put(KEY_TICKETS_EXPENSES, trip.getTicketsExpenses()); // Trip Tickets Expenses
// Inserting Row
        db.insert(TABLE_TRIPS, null, values);
        db.close(); // Closing database connection
    }
    // Getting one trip
    public Trip getTrip(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRIPS, new String[] { KEY_ID,
                        KEY_NAME, KEY_START_DATE, KEY_END_DATE, KEY_BUDGET, KEY_HOTEL_EXPENSES, KEY_TICKETS_EXPENSES}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Trip contact = new Trip(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), Double.parseDouble(cursor.getString(4)), Double.parseDouble(cursor.getString(5)), Double.parseDouble(cursor.getString(6)));
// return trip
        return contact;
    }
    // Getting All Trips
    public List<Trip> getAllTrips() {
        List<Trip> tripList = new ArrayList<Trip>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TRIPS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Trip trip = new Trip();
                trip.setId(Integer.parseInt(cursor.getString(0)));
                trip.setName(cursor.getString(1));
                trip.setStartDate(cursor.getString(2));
                trip.setEndDate(cursor.getString(3));
                trip.setOverallBudget(Double.parseDouble(cursor.getString(4)));
                trip.setHotelExpenses(Double.parseDouble(cursor.getString(5)));
                trip.setTicketsExpenses(Double.parseDouble(cursor.getString(6)));
// Adding contact to list
                tripList.add(trip);
            } while (cursor.moveToNext());
        }
// return contact list
        return tripList;
    }
    // Getting trips Count
    public int getTripsCount() {
        String countQuery = "SELECT * FROM " + TABLE_TRIPS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
// return count
        return cursor.getCount();
    }
    // Updating a trip
    public int updateTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, trip.getName());
        values.put(KEY_START_DATE, trip.getStartDate());
        values.put(KEY_END_DATE, trip.getEndDate()); // Trip Ending Date
        values.put(KEY_BUDGET, trip.getOverallBudget()); // Trip Budget
        values.put(KEY_HOTEL_EXPENSES, trip.getHotelExpenses()); // Trip Hotel Expenses
        values.put(KEY_TICKETS_EXPENSES, trip.getTicketsExpenses()); // Trip Tickets Expenses
// updating row
        return db.update(TABLE_TRIPS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(trip.getId())});
    }
    // Deleting a trip
    public void deleteTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRIPS, KEY_ID + " = ?",
                new String[] { String.valueOf(trip.getId()) });
        db.close();
    }
}

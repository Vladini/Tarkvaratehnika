package com.example.user.traveleasy;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TripUnitTest {

    private DBHandler db;

    @Before
    public void setUp(){
        DBHandler db = new DBHandler(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void finish() {
        db.close();
    }

    @Test
    public void tripSaved() throws Exception {
        Trip trip = new Trip();
        trip.setId(1);
        trip.setName("TestTrip");
        trip.setStartDate("14.03.2017");
        trip.setEndDate("19.03.2017");

        db.addTrip(trip);

        Trip savedTrip = db.getTrip(1);

        assertEquals(trip, savedTrip);
    }

    @Test
    public void tripUpdated() throws Exception {
        Trip trip = new Trip();
        trip.setId(1);
        trip.setName("TestTrip");
        trip.setStartDate("14.03.2017");
        trip.setEndDate("19.03.2017");

        db.addTrip(trip);

        Trip savedTrip = db.getTrip(1);

        String newtripName = "NewTestTrip";
        savedTrip.setName(newtripName);
        db.updateTrip(savedTrip);
        savedTrip = db.getTrip(1);

        assertEquals(savedTrip.getName(), newtripName);
    }

    @Test
    public void tripDeleted() throws Exception {
        Trip trip = new Trip();
        trip.setId(1);
        trip.setName("TestTrip");
        trip.setStartDate("14.03.2017");
        trip.setEndDate("19.03.2017");

        db.addTrip(trip);
        trip = db.getTrip(1);
        db.deleteTrip(trip);
        trip = db.getTrip(1);
        Assert.assertNull(trip);
    }
}
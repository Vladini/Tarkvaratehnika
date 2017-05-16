package com.example.user.traveleasy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BudgetActivity extends AppCompatActivity {
    public static int index;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        DBHandler db = new DBHandler(this);
        editText = (EditText) findViewById(R.id.editText11);
        editText2 = (EditText) findViewById(R.id.editText13);
        editText3 = (EditText) findViewById(R.id.editText14);
        editText4 = (EditText) findViewById(R.id.editText10);
        editText.setText(String.valueOf(db.getTrip(index).getOverallBudget()));
        editText2.setText(String.valueOf(db.getTrip(index).getHotelExpenses()));
        editText3.setText(String.valueOf(db.getTrip(index).getTicketsExpenses()));
        editText4.setText(String.valueOf(db.getTrip(index).getOtherExpenses()));
    }

    public void saveChanges(View view) {
        DBHandler db = new DBHandler(this);
        Trip trip = new Trip(index, db.getTrip(index).getName(),db.getTrip(index).getStartDate(), db.getTrip(index).getEndDate(), Double.parseDouble(editText.getText().toString()), Double.parseDouble(editText2.getText().toString()), Double.parseDouble(editText3.getText().toString()), db.getTrip(index).getNotes(), Double.parseDouble(editText4.getText().toString()));
        db.updateTrip(trip);
        AlertDialog alertDialog = new AlertDialog.Builder(BudgetActivity.this).create();
        alertDialog.setTitle("Saved");
        alertDialog.setMessage("All changes saved!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(BudgetActivity.this, TripsCalendarActivity.class));
                        TripsCalendarActivity.index = index;
                    }
                });
        alertDialog.show();
    }

    public void checkBudget(View view) {
        double budgetAmount;
        double hotelPrice;
        double ticketsPrice;
        double otherExpenses;

        if (editText.getText().toString().matches("") || Double.parseDouble(editText.getText().toString())<0) {
            budgetAmount = 0;
        } else{
            budgetAmount = Double.parseDouble(editText.getText().toString());
        }

        if (editText2.getText().toString().matches("") || Double.parseDouble(editText2.getText().toString())<0) {
            hotelPrice = 0;
        } else{
            hotelPrice = Double.parseDouble(editText2.getText().toString());
        }

        if (editText3.getText().toString().matches("") || Double.parseDouble(editText3.getText().toString())<0) {
            ticketsPrice = 0;
        } else{
            ticketsPrice = Double.parseDouble(editText3.getText().toString());
        }

        if (editText4.getText().toString().matches("") || Double.parseDouble(editText4.getText().toString())<0) {
            otherExpenses = 0;
        } else{
            otherExpenses = Double.parseDouble(editText4.getText().toString());
        }

        double result = budgetAmount-hotelPrice-ticketsPrice-otherExpenses;
        AlertDialog alertDialog = new AlertDialog.Builder(BudgetActivity.this).create();
        alertDialog.setTitle("Budget check");
        if(result>0){
            alertDialog.setMessage("Your budget is covering your expenses! You even saved " + result);
        } else if (result == 0){
            alertDialog.setMessage("Your budget is nicely covering your expenses!");
        } else if (result<0){
            alertDialog.setMessage("Your budget is NOT covering your expenses! You are lacking " + (result-2*result));
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

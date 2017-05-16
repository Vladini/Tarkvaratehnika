package com.example.user.traveleasy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTripActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Button button2;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
//        editText = (EditText) findViewById(R.id.editText4);
//        editText2 = (EditText) findViewById(R.id.editText5);
//        editText3 = (EditText) findViewById(R.id.editText6);
        editText4 = (EditText) findViewById(R.id.editText7);
        editText5 = (EditText) findViewById(R.id.editText8);
        editText6 = (EditText) findViewById(R.id.editText);
//        editText7 = (EditText) findViewById(R.id.editText9);
        button2 = (Button) findViewById(R.id.button8);
    }


   /* public void checkBudget(View view) {
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

        if (editText7.getText().toString().matches("") || Double.parseDouble(editText7.getText().toString())<0) {
            otherExpenses = 0;
        } else{
            otherExpenses = Double.parseDouble(editText7.getText().toString());
        }

        double result = budgetAmount-hotelPrice-ticketsPrice-otherExpenses;

        AlertDialog alertDialog = new AlertDialog.Builder(NewTripActivity.this).create();
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
    }*/

    public void saveTrip(View view) {
        double budgetAmount;
        double hotelPrice;
        double ticketsPrice;
        double otherExpenses;

//        if (editText.getText().toString().matches("") || Double.parseDouble(editText.getText().toString())<0) {
//            budgetAmount = 0;
//        } else{
//            budgetAmount = Double.parseDouble(editText.getText().toString());
//        }
//
//        if (editText2.getText().toString().matches("") || Double.parseDouble(editText2.getText().toString())<0) {
//            hotelPrice = 0;
//        } else{
//            hotelPrice = Double.parseDouble(editText2.getText().toString());
//        }
//
//        if (editText3.getText().toString().matches("") || Double.parseDouble(editText3.getText().toString())<0) {
//            ticketsPrice = 0;
//        } else{
//            ticketsPrice = Double.parseDouble(editText3.getText().toString());
//        }
//
//        if (editText7.getText().toString().matches("") || Double.parseDouble(editText7.getText().toString())<0) {
//            otherExpenses = 0;
//        } else{
//            otherExpenses = Double.parseDouble(editText7.getText().toString());
//        }

        if (editText6.getText().toString().matches("") || editText4.getText().toString().matches("") || editText5.getText().toString().matches("")){
            AlertDialog alertDialog = new AlertDialog.Builder(NewTripActivity.this).create();
            alertDialog.setTitle("Empty fields");
            alertDialog.setMessage("Trip name, start and end dates must be filled!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if (editText4.getText().toString().length()<10 || editText4.getText().toString().length()>10 || editText5.getText().toString().length()<10 || editText5.getText().toString().length()>10){
            AlertDialog alertDialog = new AlertDialog.Builder(NewTripActivity.this).create();
            alertDialog.setTitle("Format error");
            alertDialog.setMessage("Wrong data format! It must be dd.mm.yyyy!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else {
            DBHandler db = new DBHandler(this);
            Log.d("Insert: ", "Inserting ..");
//            db.addTrip(new Trip(1, editText6.getText().toString(), editText4.getText().toString(), editText5.getText().toString(), budgetAmount, hotelPrice, ticketsPrice, "", otherExpenses));
            AlertDialog alertDialog = new AlertDialog.Builder(NewTripActivity.this).create();
            alertDialog.setTitle("Saved");
            alertDialog.setMessage("Trip successfully saved!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}

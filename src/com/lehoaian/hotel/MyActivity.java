package com.lehoaian.hotel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MyActivity extends Activity
{

    TextView textView;

    final static int CITY_SPINNER_ID = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.txtLocation);
        // textView.setText("Shit");
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(CITY_SPINNER_ID);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            textView.setText("Now");
        }
    };

    private String[] getListOfCities(){
        return new String[]{"Paris, France", "London, England"};
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id) {
            case CITY_SPINNER_ID:
                //return new DatePickerDialog(this,dateSetListener, 2000,10,12);
                return new AlertDialog.Builder(this)
                        .setTitle("Select City")
                        .setItems(getListOfCities(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //To change body of implemented methods use File | Settings | File Templates.
                                Log.i("DIALOG", String.valueOf(i));
                            }
                        }).show();
        }


        return null;
    }
}

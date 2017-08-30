package com.example.msi.pitchbooker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Book_Pitch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1, spinner2, spinner3, spinner4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pitch);
        // Spinner element
        spinner1 = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner1.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> ballfield = new ArrayList<String>();
        ballfield.add("  1  ");
        ballfield.add("  2  ");
        ballfield.add("  3  ");
        ballfield.add("  4  ");
        ballfield.add("  5  ");
        ballfield.add("  6  ");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ballfield);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);


        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        List<String> date = new ArrayList<String>();
        date.add("D1/M1/Y1");
        date.add("D2/M1/Y1");
        date.add("D3/M1/Y1");
        date.add("D4/M1/Y1");
        date.add("D5/M1/Y1");
        date.add("D6/M1/Y1");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);
        List<String> timeStart = new ArrayList<String>();
        timeStart.add("7:00");
        timeStart.add("8:00");
        timeStart.add("9:00");
        timeStart.add("10:00");
        timeStart.add("11:00");
        timeStart.add("12:00");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timeStart);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter3);

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.setOnItemSelectedListener(this);
        List<String> timeEnd = new ArrayList<String>();
        timeEnd.add("8:00");
        timeEnd.add("9:00");
        timeEnd.add("10:00");
        timeEnd.add("11:00");
        timeEnd.add("12:00");
        timeEnd.add("1:00");
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timeEnd);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter4);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
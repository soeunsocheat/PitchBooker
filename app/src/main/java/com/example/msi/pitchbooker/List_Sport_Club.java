package com.example.msi.pitchbooker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class List_Sport_Club extends FragmentActivity {
    TextView date;
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__sport__club);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        date = (TextView)findViewById(R.id.tv_date);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://pitchbooker.gicitc.info/location/list/field/reservation/on_date";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.d("11111", "onResponse: "+response);
                        Gson gson =new Gson();

                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
                            List_Reservation list = gson.fromJson(response,List_Reservation.class);
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        List_Reservation list = gson.fromJson(response,List_Reservation.class);
                        if(list.getDate().equals("2017-10-4")){
                            String str = list.getDate();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date newDate = null;
                            try {
                                newDate = format.parse(str);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            format = new SimpleDateFormat("EEEE");
                            String strdate = format.format(newDate);
                            date.setText(strdate);
                            mTabHost.addTab(mTabHost.newTabSpec("A").setIndicator(""+list.getLocations().get(0).getLocation_name()),
                                    List_Ball_Field_A.class, null);
                            mTabHost.addTab(mTabHost.newTabSpec("B").setIndicator(""+list.getLocations().get(1).getLocation_name()),
                                    List_Ball_Field_B.class, null);
                            mTabHost.addTab(mTabHost.newTabSpec("C").setIndicator(""+list.getLocations().get(2).getLocation_name()),
                                    List_Ball_Field_C.class, null);
                            mTabHost.addTab(mTabHost.newTabSpec("D").setIndicator(""+list.getLocations().get(3).getLocation_name()),
                                    List_Ball_Field_D.class, null);
                            Intent intent = getIntent();
                            mTabHost.setCurrentTab(intent.getIntExtra("hello", 0));
                        }else{
                            Toast.makeText(List_Sport_Club.this,list.getMessage(),Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


            }
        });
        queue.add(stringRequest);
    }
}
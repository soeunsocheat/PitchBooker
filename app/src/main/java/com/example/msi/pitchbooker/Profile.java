package com.example.msi.pitchbooker;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    TextView tv_username;
    TextView tv_date1,tv_date2,tv_date3,tv_date4,tv_date5,tv_date6,tv_date7,tv_date8,tv_date9,tv_date10;
    TextView sportclub1,sportclub2,sportclub3,sportclub4,sportclub5,sportclub6,sportclub7,sportclub8,sportclub9,sportclub10;
    TextView ballfield1,ballfield2,ballfield3,ballfield4,ballfield5,ballfield6,ballfield7,ballfield8,ballfield9,ballfield10;
    TextView timeStart1,timeStart2,timeStart3,timeStart4,timeStart5,timeStart6,timeStart7,timeStart8,timeStart9,timeStart10;
    TextView timeEnd1,timeEnd2,timeEnd3,timeEnd4,timeEnd5,timeEnd6,timeEnd7,timeEnd8,timeEnd9,timeEnd10;

    static String customer_id;
    String date;
    String timeStart, timeEnd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tv_username = (TextView) view.findViewById(R.id.tv_username);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.data_app), getActivity().MODE_PRIVATE);
        tv_username.setText("Name : " + sharedPreferences.getString("customer_name", ""));
        customer_id = sharedPreferences.getString("customer_id", "");

//        id = Long.parseLong(cutomer_id);
        // list all dates
        tv_date1 = (TextView)view.findViewById(R.id.date1);
        tv_date2 = (TextView)view.findViewById(R.id.date2);
        tv_date3 = (TextView)view.findViewById(R.id.date3);
        tv_date4 = (TextView)view.findViewById(R.id.date4);
        tv_date5 = (TextView)view.findViewById(R.id.date5);
        tv_date6 = (TextView)view.findViewById(R.id.date6);
        tv_date7 = (TextView)view.findViewById(R.id.date7);
        tv_date8 = (TextView)view.findViewById(R.id.date8);
        tv_date9 = (TextView)view.findViewById(R.id.date9);
        tv_date10 = (TextView)view.findViewById(R.id.date10);

        // list all sportclubs
        sportclub1 = (TextView)view.findViewById(R.id.sportclub1);
        sportclub2 = (TextView)view.findViewById(R.id.sportclub2);
        sportclub3 = (TextView)view.findViewById(R.id.sportclub3);
        sportclub4 = (TextView)view.findViewById(R.id.sportclub4);
        sportclub5 = (TextView)view.findViewById(R.id.sportclub5);
        sportclub6 = (TextView)view.findViewById(R.id.sportclub6);
        sportclub7 = (TextView)view.findViewById(R.id.sportclub7);
        sportclub8 = (TextView)view.findViewById(R.id.sportclub8);
        sportclub9 = (TextView)view.findViewById(R.id.sportclub9);
        sportclub10 = (TextView)view.findViewById(R.id.sportclub10);

        // list all ballfield
        ballfield1 = (TextView)view.findViewById(R.id.ballfield1);
        ballfield2 = (TextView)view.findViewById(R.id.ballfield2);
        ballfield3 = (TextView)view.findViewById(R.id.ballfield3);
        ballfield4 = (TextView)view.findViewById(R.id.ballfield4);
        ballfield5 = (TextView)view.findViewById(R.id.ballfield5);
        ballfield6 = (TextView)view.findViewById(R.id.ballfield6);
        ballfield7 = (TextView)view.findViewById(R.id.ballfield7);
        ballfield8 = (TextView)view.findViewById(R.id.ballfield8);
        ballfield9 = (TextView)view.findViewById(R.id.ballfield9);
        ballfield10 = (TextView)view.findViewById(R.id.ballfield10);

        // list all time start
        timeStart1 = (TextView)view.findViewById(R.id.timestart1);
        timeStart2 = (TextView)view.findViewById(R.id.timestart2);
        timeStart3 = (TextView)view.findViewById(R.id.timestart3);
        timeStart4 = (TextView)view.findViewById(R.id.timestart4);
        timeStart5 = (TextView)view.findViewById(R.id.timestart5);
        timeStart6 = (TextView)view.findViewById(R.id.timestart6);
        timeStart7 = (TextView)view.findViewById(R.id.timestart7);
        timeStart8 = (TextView)view.findViewById(R.id.timestart8);
        timeStart9 = (TextView)view.findViewById(R.id.timestart9);
        timeStart10 = (TextView)view.findViewById(R.id.timestart10);

        // list all time end
        timeEnd1 = (TextView)view.findViewById(R.id.timeend1);
        timeEnd2 = (TextView)view.findViewById(R.id.timeend2);
        timeEnd3 = (TextView)view.findViewById(R.id.timeend3);
        timeEnd4 = (TextView)view.findViewById(R.id.timeend4);
        timeEnd5 = (TextView)view.findViewById(R.id.timeend5);
        timeEnd6 = (TextView)view.findViewById(R.id.timeend6);
        timeEnd7 = (TextView)view.findViewById(R.id.timeend7);
        timeEnd8 = (TextView)view.findViewById(R.id.timeend8);
        timeEnd9 = (TextView)view.findViewById(R.id.timeend9);
        timeEnd10 = (TextView)view.findViewById(R.id.timeend10);

        listBookField();
        return view;
    }

    private void listBookField() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info/customer/get/reserve_list";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Reserve_List reserve_list = gson.fromJson(response, Reserve_List.class);
                for (int i = 0; i < reserve_list.getReserve_lists().size(); i++){
                    // field_id
                    long fied_id = reserve_list.getReserve_lists().get(i).getField_id();

                    // change date from yyyy-MM-dd to dd-MMM-yyyy
                    date = reserve_list.getReserve_lists().get(i).getReserve_date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date newDate = null;
                    try {
                        newDate = format.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    format = new SimpleDateFormat("dd-MMM-yyyy");
                    String strdate = format.format(newDate);

                    // change time Start from hh:mm:ss to hh:mm a
                    timeStart = reserve_list.getReserve_lists().get(i).getReserve_start_time();
                    SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
                    Date newDate1 = null;
                    try {
                        newDate1 = format1.parse(timeStart);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    format1 = new SimpleDateFormat("H:mm a");
                    String ts = format1.format(newDate1);

                    // change time End from hh:mm:ss to hh:mm a
                    timeEnd = reserve_list.getReserve_lists().get(i).getReserve_end_time();
                    SimpleDateFormat format2 = new SimpleDateFormat("hh:mm:ss");
                    Date newDate2 = null;
                    try {
                        newDate2 = format2.parse(timeEnd);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    format1 = new SimpleDateFormat("H:mm a");
                    String te = format1.format(newDate2);

                    if (i == 0){
                        tv_date1.setText(strdate);
                        timeStart1.setText(ts);
                        timeEnd1.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub1.setText("Location A");
                            if (fied_id == 100){
                                ballfield1.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield1.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield1.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield1.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield1.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield1.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub1.setText("Location B");
                            if (fied_id == 200){
                                ballfield1.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield1.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield1.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield1.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield1.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield1.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub1.setText("Location C");
                            if (fied_id == 300){
                                ballfield1.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield1.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield1.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield1.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield1.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield1.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub1.setText("Location D");
                            if (fied_id == 400){
                                ballfield1.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield1.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield1.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield1.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield1.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield1.setText("D 6");
                            }
                        }
                    }
                    if (i == 1){
                        tv_date2.setText(strdate);
                        timeStart2.setText(ts);
                        timeEnd2.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub2.setText("Location A");
                            if (fied_id == 100){
                                ballfield2.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield2.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield2.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield2.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield2.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield2.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub2.setText("Location B");
                            if (fied_id == 200){
                                ballfield2.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield2.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield2.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield2.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield2.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield2.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub2.setText("Location C");
                            if (fied_id == 300){
                                ballfield2.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield2.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield2.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield2.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield2.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield2.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub2.setText("Location D");
                            if (fied_id == 400){
                                ballfield2.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield2.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield2.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield2.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield2.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield2.setText("D 6");
                            }
                        }
                    }
                    if (i == 2){
                        tv_date3.setText(strdate);
                        timeStart3.setText(ts);
                        timeEnd3.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub3.setText("Location A");
                            if (fied_id == 100){
                                ballfield3.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield3.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield3.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield3.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield3.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield3.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub3.setText("Location B");
                            if (fied_id == 200){
                                ballfield3.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield3.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield3.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield3.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield3.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield3.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub3.setText("Location C");
                            if (fied_id == 300){
                                ballfield3.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield3.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield3.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield3.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield3.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield3.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub3.setText("Location D");
                            if (fied_id == 400){
                                ballfield3.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield3.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield3.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield3.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield3.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield3.setText("D 6");
                            }
                        }
                    }
                    if (i == 3){
                        tv_date4.setText(strdate);
                        timeStart4.setText(ts);
                        timeEnd4.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub4.setText("Location A");
                            if (fied_id == 100){
                                ballfield4.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield4.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield4.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield4.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield4.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield4.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub4.setText("Location B");
                            if (fied_id == 200){
                                ballfield4.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield4.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield4.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield4.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield4.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield4.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub4.setText("Location C");
                            if (fied_id == 300){
                                ballfield4.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield4.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield4.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield4.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield4.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield4.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub4.setText("Location D");
                            if (fied_id == 400){
                                ballfield4.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield4.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield4.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield4.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield4.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield4.setText("D 6");
                            }
                        }
                    }
                    if (i == 4){
                        tv_date5.setText(strdate);
                        timeStart5.setText(ts);
                        timeEnd5.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub5.setText("Location A");
                            if (fied_id == 100){
                                ballfield5.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield5.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield5.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield5.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield5.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield5.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub5.setText("Location B");
                            if (fied_id == 200){
                                ballfield5.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield5.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield5.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield5.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield5.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield5.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub5.setText("Location C");
                            if (fied_id == 300){
                                ballfield5.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield5.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield5.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield5.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield5.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield5.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub5.setText("Location D");
                            if (fied_id == 400){
                                ballfield5.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield5.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield5.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield5.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield5.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield5.setText("D 6");
                            }
                        }
                    }
                    if (i == 5){
                        tv_date6.setText(strdate);
                        timeStart6.setText(ts);
                        timeEnd6.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub6.setText("Location A");
                            if (fied_id == 100){
                                ballfield6.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield6.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield6.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield6.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield6.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield6.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub6.setText("Location B");
                            if (fied_id == 200){
                                ballfield6.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield6.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield6.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield6.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield6.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield6.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub6.setText("Location C");
                            if (fied_id == 300){
                                ballfield6.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield6.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield6.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield6.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield6.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield6.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub6.setText("Location D");
                            if (fied_id == 400){
                                ballfield6.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield6.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield6.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield6.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield6.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield6.setText("D 6");
                            }
                        }
                    }
                    if (i == 6){
                        tv_date7.setText(strdate);
                        timeStart7.setText(ts);
                        timeEnd7.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub7.setText("Location A");
                            if (fied_id == 100){
                                ballfield7.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield7.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield7.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield7.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield7.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield7.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub7.setText("Location B");
                            if (fied_id == 200){
                                ballfield7.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield7.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield7.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield7.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield7.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield7.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub7.setText("Location C");
                            if (fied_id == 300){
                                ballfield7.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield7.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield7.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield7.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield7.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield7.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub7.setText("Location D");
                            if (fied_id == 400){
                                ballfield7.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield7.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield7.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield7.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield7.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield7.setText("D 6");
                            }
                        }
                    }
                    if (i == 7){
                        tv_date8.setText(strdate);
                        timeStart8.setText(ts);
                        timeEnd8.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub8.setText("Location A");
                            if (fied_id == 100){
                                ballfield8.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield8.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield8.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield8.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield8.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield8.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub8.setText("Location B");
                            if (fied_id == 200){
                                ballfield8.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield8.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield8.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield8.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield8.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield8.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub8.setText("Location C");
                            if (fied_id == 300){
                                ballfield8.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield8.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield8.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield8.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield8.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield8.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub8.setText("Location D");
                            if (fied_id == 400){
                                ballfield8.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield8.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield8.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield8.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield8.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield8.setText("D 6");
                            }
                        }
                    }
                    if (i == 8){
                        tv_date9.setText(strdate);
                        timeStart9.setText(ts);
                        timeEnd9.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub9.setText("Location A");
                            if (fied_id == 100){
                                ballfield9.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield9.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield9.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield9.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield9.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield9.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub9.setText("Location B");
                            if (fied_id == 200){
                                ballfield9.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield9.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield9.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield9.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield9.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield9.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub9.setText("Location C");
                            if (fied_id == 300){
                                ballfield9.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield9.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield9.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield9.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield9.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield9.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub9.setText("Location D");
                            if (fied_id == 400){
                                ballfield9.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield9.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield9.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield9.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield9.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield9.setText("D 6");
                            }
                        }
                    }
                    if (i == 9){
                        tv_date10.setText(strdate);
                        timeStart10.setText(ts);
                        timeEnd10.setText(te);
                        if (fied_id == 100 || fied_id == 101 || fied_id == 102 || fied_id == 103 || fied_id == 104 || fied_id == 105){
                            sportclub10.setText("Location A");
                            if (fied_id == 100){
                                ballfield10.setText("A 1");
                            }
                            if (fied_id == 101){
                                ballfield10.setText("A 2");
                            }
                            if (fied_id == 102){
                                ballfield10.setText("A 3");
                            }
                            if (fied_id == 103){
                                ballfield10.setText("A 4");
                            }
                            if (fied_id == 104){
                                ballfield10.setText("A 5");
                            }
                            if (fied_id == 105){
                                ballfield10.setText("A 6");
                            }
                        }
                        if (fied_id == 200 || fied_id == 201 || fied_id == 202 || fied_id == 203 || fied_id == 204 || fied_id == 205){
                            sportclub10.setText("Location B");
                            if (fied_id == 200){
                                ballfield10.setText("B 1");
                            }
                            if (fied_id == 201){
                                ballfield10.setText("B 2");
                            }
                            if (fied_id == 202){
                                ballfield10.setText("B 3");
                            }
                            if (fied_id == 203){
                                ballfield10.setText("B 4");
                            }
                            if (fied_id == 204){
                                ballfield10.setText("B 5");
                            }
                            if (fied_id == 205){
                                ballfield10.setText("B 6");
                            }
                        }
                        if (fied_id == 300 || fied_id == 301 || fied_id == 302 || fied_id == 303 || fied_id == 304 || fied_id == 305){
                            sportclub10.setText("Location C");
                            if (fied_id == 300){
                                ballfield10.setText("C 1");
                            }
                            if (fied_id == 301){
                                ballfield10.setText("C 2");
                            }
                            if (fied_id == 302){
                                ballfield10.setText("C 3");
                            }
                            if (fied_id == 303){
                                ballfield10.setText("C 4");
                            }
                            if (fied_id == 304){
                                ballfield10.setText("C 5");
                            }
                            if (fied_id == 305){
                                ballfield10.setText("C 6");
                            }
                        }
                        if (fied_id == 400 || fied_id == 401 || fied_id == 402 || fied_id == 403 || fied_id == 404 || fied_id == 405){
                            sportclub10.setText("Location D");
                            if (fied_id == 400){
                                ballfield10.setText("D 1");
                            }
                            if (fied_id == 401){
                                ballfield10.setText("D 2");
                            }
                            if (fied_id == 402){
                                ballfield10.setText("D 3");
                            }
                            if (fied_id == 403){
                                ballfield10.setText("D 4");
                            }
                            if (fied_id == 404){
                                ballfield10.setText("D 5");
                            }
                            if (fied_id == 405){
                                ballfield10.setText("D 6");
                            }
                        }
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("customer_id", customer_id);
                return hashMap;
            }
        };
        queue.add(stringRequest);
    }
}

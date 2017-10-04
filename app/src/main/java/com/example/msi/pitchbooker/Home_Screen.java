package com.example.msi.pitchbooker;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Screen extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    Button btnA, btnB, btnC, btnD;
    TextView tv_date;
    Intent intent;
    static long num;

    public Home_Screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home__screen, container, false);

        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btnA = (Button) view.findViewById(R.id.btnA);
        btnB = (Button) view.findViewById(R.id.btnB);
        btnC = (Button) view.findViewById(R.id.btnC);
        btnD = (Button) view.findViewById(R.id.btnD);
        tv_date = (TextView) view.findViewById(R.id.tv_date);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        ballfield();
        ballfieldbydate();
        return view;
    }

    private void ballfield() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info/location/list/field/reservation/today";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                        if(list.isStatus()){
                            String str = list.getDate();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date newDate = null;
                            try {
                                newDate = format.parse(str);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            format = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                            String strdate = format.format(newDate);
                            tv_date.setText(strdate);
                            btnA.setText(list.getLocations().get(0).getLocation_name());
                            btnB.setText(list.getLocations().get(1).getLocation_name());
                            btnC.setText(list.getLocations().get(2).getLocation_name());
                            btnD.setText(list.getLocations().get(3).getLocation_name());
                        }else{
                            Toast.makeText(getContext(),list.getMessage(),Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
        //                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


                    }
                }
        );
        queue.add(stringRequest);
    }

    private void ballfieldbydate() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info/location/list/field/reservation/today";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson =new Gson();

                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
//                            List_Reservation list = gson.fromJson(response,List_Reservation.class);
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        List_Reservation list = gson.fromJson(response,List_Reservation.class);
                        if(list.isStatus()){
                            String str = list.getDate();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date newDate = null;
                            try {
                                newDate = format.parse(str);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            format = new SimpleDateFormat("EEEE\n\ndd-MM-yyyy");
                            String strdate = format.format(newDate);
                            btn1.setText(strdate);

                            Calendar cal = Calendar.getInstance();
                            cal.setTime(newDate);
                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday2 = format.format(cal.getTime());
                            btn2.setText(strday2);

                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday3 = format.format(cal.getTime());
                            btn3.setText(strday3);

                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday4 = format.format(cal.getTime());
                            btn4.setText(strday4);

                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday5 = format.format(cal.getTime());
                            btn5.setText(strday5);

                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday6 = format.format(cal.getTime());
                            btn6.setText(strday6);

                            cal.add(Calendar.DAY_OF_MONTH,1);
                            String strday7 = format.format(cal.getTime());
                            btn7.setText(strday7);
                        }else{
                            Toast.makeText(getContext(),list.getMessage(),Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


            }
        }
        );
        queue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn6:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btn7:
                intent = new Intent(getContext(), List_Sport_Club.class);
                startActivity(intent);
                break;
            case R.id.btnA:
                intent = new Intent(getActivity(), List_Sport_Club.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 0);
                getActivity().startActivity(intent);
                break;
            case R.id.btnB:
                intent = new Intent(getActivity(), List_Sport_Club.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 1);
                getActivity().startActivity(intent);
                break;
            case R.id.btnC:
                intent = new Intent(getContext(), List_Sport_Club.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 2);
                getContext().startActivity(intent);
                break;
            case R.id.btnD:
                intent = new Intent(getContext(), List_Sport_Club.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 3);
                getContext().startActivity(intent);
                break;
        }
    }
}
package com.example.msi.pitchbooker;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Screen extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    Button btnA, btnB, btnC, btnD;
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
        return view;
    }

    private void ballfield() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info/location/list";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        Gson gson =new Gson();

                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
                            List_Reservation list = gson.fromJson(response,List_Reservation.class);
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();
                            Toast.makeText(getContext(),"status : "+list.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        List_Reservation list = gson.fromJson(response,List_Reservation.class);
                        if(list.isStatus()){
                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getResources().getString(R.string.data_app),getActivity().MODE_PRIVATE);
                            SharedPreferences.Editor editor =sharedPreferences.edit();

                        }else{
                            Toast.makeText(getContext(),list.getMessage(),Toast.LENGTH_LONG).show();
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
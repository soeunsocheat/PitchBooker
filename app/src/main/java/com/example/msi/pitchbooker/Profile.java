package com.example.msi.pitchbooker;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
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

import java.util.ArrayList;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tv_username = (TextView) view.findViewById(R.id.tv_username);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.data_app), getActivity().MODE_PRIVATE);
        tv_username.setText("Name : " + sharedPreferences.getString("customer_name", ""));

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

        return view;
    }
}

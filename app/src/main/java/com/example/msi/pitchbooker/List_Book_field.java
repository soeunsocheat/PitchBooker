package com.example.msi.pitchbooker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class List_Book_field extends ArrayAdapter<String > {
    TextView tv_id, tv_date, tv_sportclub, tv_ballfield, tv_timestart, tv_timeend;
    List <Reserve_List> book;
    long customer_id;


    public List_Book_field(Context context) {
        super(context, R.layout.activity_list__book_field);
        this.book = book;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null) {//new item or old but was removed for gaining memory
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_list__book_field, parent, false);
            Log.d("MyArrayAcitivity", "Pos:" + position + ", convertView:" + convertView);
        } else {
            Log.d("MyArrayAcitivity", "Pos:" + position);
        }
        String id = getItem(position+1);

        tv_id = convertView.findViewById(R.id.id);
        tv_id.setText(id);
        tv_date = (TextView)convertView.findViewById(R.id.date);
        tv_sportclub = (TextView)convertView.findViewById(R.id.sportclub);
        tv_ballfield = (TextView)convertView.findViewById(R.id.ballfield);
        tv_timestart = (TextView)convertView.findViewById(R.id.timestart);
        tv_timeend = (TextView)convertView.findViewById(R.id.timeend);

        ListBook();
        return convertView;
    }

    private void ListBook() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info//customer/get/reserve_list";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getString(R.string.data_app), getContext().MODE_PRIVATE);
                customer_id = sharedPreferences.getLong("customer_name", 0);
                Reserve_List reserve_list = gson.fromJson(response, Reserve_List.class);

                for (int i = 0; i < reserve_list.getReserve_lists().size(); i++) {
                    tv_date.setText(reserve_list.getReserve_lists().get(i).getReserve_date());
                    tv_timestart.setText(reserve_list.getReserve_lists().get(i).getReserve_start_time());
                    tv_timeend.setText(reserve_list.getReserve_lists().get(i).getReserve_end_time());
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
                hashMap.put("customer_id", ""+customer_id);
                return hashMap;
            }
        };
        queue.add(stringRequest);
    }
}

package com.example.msi.pitchbooker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSI on 9/7/2017.
 */

public class List_Ball_Field_A extends Fragment {
    TextView f1, f2, f3, f4, f5, f6;
    static String day;
    private ListView listItem;
    private ArrayList<Table_Field_value> values;
    private ArrayList<String> times;
    private List_Item_A items;
    public static String[] pitch = {"A 1", "A 2", "A 3", "A 4", "A 5", "A 6"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        times = new ArrayList<>();

        for (String t: Table_Field_value.time00){
            times.add(t);
        }

        View v = inflater.inflate(R.layout.list_ball_field, container, false);
        values = new ArrayList<>();
        items = new List_Item_A(getActivity(), times, values);
        listItem = (ListView) v.findViewById(R.id.list_ball_field);
        listItem.setAdapter(items);

        f1 = (TextView) v.findViewById(R.id.f1);
        f2 = (TextView) v.findViewById(R.id.f2);
        f3 = (TextView) v.findViewById(R.id.f3);
        f4 = (TextView) v.findViewById(R.id.f4);
        f5 = (TextView) v.findViewById(R.id.f5);
        f6 = (TextView) v.findViewById(R.id.f6);


        ListBallField();
        return v;
    }

    private void ListBallField() {
        Intent date = getActivity().getIntent();
        day = date.getStringExtra("date");
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = getString(R.string.url_reservationOnDay);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List_Reservation list = gson.fromJson(response, List_Reservation.class);
                // A Field Location
                ArrayList<Field> fields = list.getLocations().get(0).getFields();
                for (int i = 0; i < fields.size(); i++) {
                    for (int j = 0; j < fields.get(i).getReservations().size(); j++){
                        Table_Field_value table_field_value = new Table_Field_value();
                        table_field_value.setPitch(fields.get(i).getReservations().get(j).getField_id());
                        table_field_value.setT11(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT21(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT12(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT22(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT13(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT23(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT14(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT24(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT15(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT25(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT16(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setT26(fields.get(i).getReservations().get(j).getReserve_start_time());
                        values.add(table_field_value);
                    }
                }



                if (list.isStatus()) {
                    f1.setText(list.getLocations().get(0).getFields().get(0).getField_name());
                    f2.setText(list.getLocations().get(0).getFields().get(1).getField_name());
                    f3.setText(list.getLocations().get(0).getFields().get(2).getField_name());
                    f4.setText(list.getLocations().get(0).getFields().get(3).getField_name());
                    f5.setText(list.getLocations().get(0).getFields().get(4).getField_name());
                    f6.setText(list.getLocations().get(0).getFields().get(5).getField_name());
                }
                items.notifyDataSetChanged();
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
                hashMap.put("date", day);
                return hashMap;
            }
        };
        queue.add(stringRequest);
    }
}

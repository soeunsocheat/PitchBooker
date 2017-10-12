package com.example.msi.pitchbooker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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
import java.util.Map;

/**
 * Created by MSI on 9/7/2017.
 */

public class List_Ball_Field_A extends Fragment {
    TextView f1, f2, f3, f4, f5, f6;
    String day;
    private ListView listItem;
    private ArrayList<Table_Field_value> values;
    private ArrayList<String> times;
    private List_Item items;
    public static String[] time = {"7:00", "8:00", "9:00", "10:00"
            , "11:00", "12:00", "13:00 ", "14:00", "15:00", "16:00"
            , "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"};
    public static String[] time30 = {"7:30", "8:30", "9:30", "10:30"
            , "11:30", "12:30", "13:30 ", "14:30", "15:30", "16:30"
            , "17:30", "18:30", "19:30", "20:30", "21:30", "22:30"};


    //    private static Item[] times;
//    {
//
//        times = new Item[time.length * 1];
//        for (int i = 0; i < time.length; i++) {
//            times[i] = new Item(time[i]);
//        }
////        for (int i = 0; i < namesStr.length; i++) {
////            names[namesStr.length + i] = new Student(resIds[i], namesStr[i]);
////        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        times = new ArrayList<>();

        for (String t: time){
            times.add(t);
        }

        View v = inflater.inflate(R.layout.list_ball_field, container, false);
        values = new ArrayList<>();
        items = new List_Item(getActivity(), times, values);
        listItem = (ListView) v.findViewById(R.id.listballfield);
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
        String url = "http://pitchbooker.gicitc.info/location/list/field/reservation/on_date";
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

                        table_field_value.setS11(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE11(fields.get(i).getReservations().get(j).getReserve_end_time());

                        table_field_value.setS12(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE12(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS13(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE13(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS14(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE14(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS15(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE15(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS16(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE16(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS21(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE21(fields.get(i).getReservations().get(j).getReserve_end_time());


                        table_field_value.setS22(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE22(fields.get(i).getReservations().get(j).getReserve_end_time());

                        table_field_value.setS23(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE23(fields.get(i).getReservations().get(j).getReserve_end_time());

                        table_field_value.setS24(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE24(fields.get(i).getReservations().get(j).getReserve_end_time());

                        table_field_value.setS25(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE25(fields.get(i).getReservations().get(j).getReserve_end_time());

                        table_field_value.setS26(fields.get(i).getReservations().get(j).getReserve_start_time());
                        table_field_value.setE26(fields.get(i).getReservations().get(j).getReserve_end_time());

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

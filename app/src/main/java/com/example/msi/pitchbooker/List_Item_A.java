package com.example.msi.pitchbooker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_Item_A extends ArrayAdapter<String>{
    List<Table_Field_value> values;
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    Dialog dialog;
    String ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9, ts10, ts11, ts12;
    String te1, te2, te3, te4, te5, te6, te7, te8, te9, te10, te11, te12;
    String p1, p2, p3, p4, p5, p6;


    public List_Item_A(@NonNull Context context, @NonNull List<String> objects, List<Table_Field_value> values) {
        super(context, R.layout.activity_list__item, objects);
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if(convertView == null){//new item or old but was removed for gaining memory
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_list__item, parent, false);
            Log.d("MyArrayAcitivity","Pos:"+position+", convertView:"+convertView);
        }else{
            Log.d("MyArrayAcitivity","Pos:"+position);
        }

        String time = getItem(position);
        TextView textView = convertView.findViewById(R.id.time);
        textView.setText(time);


        try {

            final TextView f11 = convertView.findViewById(R.id.f11);
            final TextView f21 = convertView.findViewById(R.id.f21);
            final TextView f12 = convertView.findViewById(R.id.f12);
            final TextView f22 = convertView.findViewById(R.id.f22);
            final TextView f13 = convertView.findViewById(R.id.f13);
            final TextView f23 = convertView.findViewById(R.id.f23);
            final TextView f14 = convertView.findViewById(R.id.f14);
            final TextView f24 = convertView.findViewById(R.id.f24);
            final TextView f15 = convertView.findViewById(R.id.f15);
            final TextView f25 = convertView.findViewById(R.id.f25);
            final TextView f16 = convertView.findViewById(R.id.f16);
            final TextView f26 = convertView.findViewById(R.id.f26);

            f11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 1;
                    ts1 = Table_Field_value.time00[position];
                    te1 = Table_Field_value.time30[position];
                    p1 = List_Ball_Field_A.pitch[0];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts1
                            + "\n\nTime End                 : " + te1
                            + "\n\nType of Pitch           : " + p1);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f11.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });
            f21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 2;
                    te2 = Table_Field_value.time00[position+1];
                    ts2 = Table_Field_value.time30[position];
                    p1 = List_Ball_Field_A.pitch[0];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts2
                            + "\n\nTime End                 : " + te2
                            + "\n\nType of Pitch           : " + p1);


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f21.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 3;
                    ts3 = Table_Field_value.time00[position];
                    te3 = Table_Field_value.time30[position];
                    p2 = List_Ball_Field_A.pitch[1];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts3
                            + "\n\nTime End                 : " + te3
                            + "\n\nType of Pitch           : " + p2);


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f12.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 4;
                    te4 = Table_Field_value.time00[position+1];
                    ts4 = Table_Field_value.time30[position];
                    p2 = List_Ball_Field_A.pitch[1];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts4
                            + "\n\nTime End                 : " + te4
                            + "\n\nType of Pitch           : " + p2);


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f22.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 5;
                    ts5 = Table_Field_value.time00[position];
                    te5 = Table_Field_value.time30[position];
                    p3 = List_Ball_Field_A.pitch[2];
                    builder.setMessage("Time Start               : " + ts5
                            + "\n\nTime End                 : " + te5
                            + "\n\nType of Pitch           : " + p3);


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f13.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 6;
                    te6 = Table_Field_value.time00[position+1];
                    ts6 = Table_Field_value.time30[position];
                    p3 = List_Ball_Field_A.pitch[2];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts6
                            + "\n\nTime End                 : " + te6
                            + "\n\nType of Pitch           : " + p3);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f23.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 7;
                    ts7 = Table_Field_value.time00[position];
                    te7 = Table_Field_value.time30[position];
                    p4 = List_Ball_Field_A.pitch[3];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts7
                            + "\n\nTime End                 : " + te7
                            + "\n\nType of Pitch           : " + p4);


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f14.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 8;
                    te8 = Table_Field_value.time00[position+1];
                    ts8 = Table_Field_value.time30[position];
                    p4 = List_Ball_Field_A.pitch[3];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts8
                            + "\n\nTime End                 : " + te8
                            + "\n\nType of Pitch           : " + p4);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f24.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 9;
                    ts9 = Table_Field_value.time00[position];
                    te9 = Table_Field_value.time30[position];
                    p5 = List_Ball_Field_A.pitch[4];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts9
                            + "\n\nTime End                 : " + te9
                            + "\n\nType of Pitch           : " + p5);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f15.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 10;
                    te10 = Table_Field_value.time00[position+1];
                    ts10 = Table_Field_value.time30[position];
                    p5 = List_Ball_Field_A.pitch[4];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts10
                            + "\n\nTime End                 : " + te10
                            + "\n\nType of Pitch           : " + p5);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f25.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 11;
                    ts11 = Table_Field_value.time00[position];
                    te11 = Table_Field_value.time30[position];
                    p6 = List_Ball_Field_A.pitch[5];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts11
                            + "\n\nTime End                 : " + te11
                            + "\n\nType of Pitch           : " + p6);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f16.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });

            f26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 12;
                    te12 = Table_Field_value.time00[position+1];
                    ts12 = Table_Field_value.time30[position];
                    p6 = List_Ball_Field_A.pitch[5];
                    builder.setTitle("Booking Pitch");
                    builder.setMessage("Time Start               : " + ts12
                            + "\n\nTime End                 : " + te12
                            + "\n\nType of Pitch           : " + p6);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            f26.setBackgroundColor(Color.BLUE);
                            book_pitch();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
            });
//            Log.d("123", "getView: "+position+ values.get(position).getPitch()+ "\n"+ values.get(position).getT11()+ "\n"+ Table_Field_value.time00[position]);
//            if (values.get(position).getT11().equals("07:00:00") ) {
//                if(values.get(position).getPitch() == 100) {
//                    f11.setBackgroundColor(Color.RED);
//                    f21.setBackgroundColor(Color.RED);
//                }
//                if (values.get(position).getPitch() == 101){
//                    f11.setBackgroundColor(Color.RED);
//                    f21.setBackgroundColor(Color.RED);
//                }
//                if(values.get(position).getPitch() == 102) {
//                    f11.setBackgroundColor(Color.RED);
//                    f21.setBackgroundColor(Color.RED);
//                }
//                if (values.get(position).getPitch() == 10){
//                    f11.setBackgroundColor(Color.RED);
//                    f21.setBackgroundColor(Color.RED);
//                }
//            }

//            if (values.get(position).getT11().equals("09:00:00") ) {
//                f11.setBackgroundColor(Color.RED);
//                f21.setBackgroundColor(Color.RED);
//            }
//            if (values.get(position).getPitch() == 100 && values.get(position).getT11().equals("13:00:00") ) {
//                f11.setBackgroundColor(Color.RED);
//                f21.setBackgroundColor(Color.RED);
//            }



//            if (values.get(position).getPitch() == 101 && values.get(position).getT12() == Table_Field_value.time00[position] ) {
//                f12.setBackgroundColor(Color.RED);
//                f22.setBackgroundColor(Color.RED);
//            }
//            if(values.get(position).getPitch() == 102 && values.get(0).getT13() != ts5 ){
//                f13.setBackgroundColor(Color.RED);
//                f23.setBackgroundColor(Color.RED);
//            }
//            if (values.get(0).getPitch() != 103 && values.get(position).getT14() != ts7 && values.get(position).getT24() != ts8) {
//                f14.setBackgroundColor(Color.RED);
//            }
//            if(values.get(0).getPitch() != 103 && values.get(position).getT24() != ts8){
//                f24.setBackgroundColor(Color.RED);
//            }
//            if(values.get(0).getPitch() != 104 && values.get(position).getT15() != ts9 && values.get(position).getT25() != ts10){
//                f15.setBackgroundColor(Color.RED);
//            }
//            if(values.get(0).getPitch() != 104 && values.get(position).getT25() != ts10){
//                f25.setBackgroundColor(Color.RED);
//            }
//            if (values.get(0).getPitch() != 105 && values.get(position).getT16() != ts11 && values.get(position).getT26() != ts12) {
//                f16.setBackgroundColor(Color.RED);
//            }
//            if(values.get(0).getPitch() != 105 && values.get(position).getT26() != ts12) {
//                f26.setBackgroundColor(Color.RED);
//            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }
    int i;
    String day;
    long field_id;
    String customer_id;
    String timeStart;
    String timeEnd;

    private void book_pitch() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getString(R.string.data_app), getContext().MODE_PRIVATE);
        customer_id = sharedPreferences.getString("customer_id", "");
        List_Ball_Field_A a = new List_Ball_Field_A();
        day = a.day;
        if (i==1){
            field_id = 100;
            timeStart = ts1;
            timeEnd = te1;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts1+ "\n"+te1, Toast.LENGTH_LONG).show();
        }

        if(i==2){
            field_id = 100;
            timeStart = ts2;
            timeEnd = te2;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts2+ "\n"+te2, Toast.LENGTH_SHORT).show();
        }
        if (i==3){
            field_id = 101;
            timeStart = ts3;
            timeEnd = te3;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts3+ "\n"+te3, Toast.LENGTH_SHORT).show();
        }

        if (i==4){
            field_id = 101;
            timeStart = ts4;
            timeEnd = te4;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts4+ "\n"+te4, Toast.LENGTH_SHORT).show();
        }
        if (i==5){
            field_id = 102;
            timeStart = ts5;
            timeEnd = te5;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts5+ "\n"+te5, Toast.LENGTH_SHORT).show();
        }
        if (i==6){
            field_id = 102;
            timeStart = ts6;
            timeEnd = te6;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts6+ "\n"+te6, Toast.LENGTH_SHORT).show();
        }
        if (i==7){
            field_id = 103;
            timeStart = ts7;
            timeEnd = te7;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts7+ "\n"+te7, Toast.LENGTH_SHORT).show();
        }
        if (i==8){
            field_id = 103;
            timeStart = ts8;
            timeEnd = te8;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts8+ "\n"+te8, Toast.LENGTH_SHORT).show();
        }
        if (i==9){
            field_id = 104;
            timeStart = ts9;
            timeEnd = te9;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts9+ "\n"+te9, Toast.LENGTH_SHORT).show();
        }
        if (i==10){
            field_id = 104;
            timeStart = ts10;
            timeEnd = te10;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts10+ "\n"+te10, Toast.LENGTH_SHORT).show();
        }
        if (i==11){
            field_id = 105;
            timeStart = ts11;
            timeEnd = te11;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts11+ "\n"+te11, Toast.LENGTH_SHORT).show();
        }
        if (i==12){
            field_id = 105;
            timeStart = ts12;
            timeEnd = te12;
//                        Toast.makeText(getContext(),""+field_id+"\n"+customer_id + "\n"+day+"\n"+ts12+ "\n"+te12, Toast.LENGTH_SHORT).show();
        }
//        Toast.makeText(getContext(), ""+field_id +"\n" + customer_id+ "\n"+ timeStart+ "\n"+ timeEnd, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = getContext().getString(R.string.url_reservationAdd);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                LoginResponse login = gson.fromJson(response, LoginResponse.class);
                if (login.isStatus()){
                    Toast.makeText(getContext(), "Message: " + login.getMsg(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Message: " + login.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("field_id", String.valueOf(field_id));
                hashMap.put("customer_id", customer_id);
                hashMap.put("reserve_date", day);
                hashMap.put("reserve_start_time", timeStart);
                hashMap.put("reserve_end_time", timeEnd);
                return hashMap;
            }
        }
        ;
        queue.add(stringRequest);
    }
}

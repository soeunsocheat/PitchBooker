package com.example.msi.pitchbooker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class List_Item extends ArrayAdapter<String>{

    List<Table_Field_value> values;
    public List_Item(@NonNull Context context, @NonNull List<String> objects, List<Table_Field_value> values) {
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

            TextView f11 = convertView.findViewById(R.id.f11);
            TextView f21 = convertView.findViewById(R.id.f21);
            TextView f12 = convertView.findViewById(R.id.f12);
            TextView f22 = convertView.findViewById(R.id.f22);
            TextView f13 = convertView.findViewById(R.id.f13);
            TextView f23 = convertView.findViewById(R.id.f23);
            TextView f14 = convertView.findViewById(R.id.f14);
            TextView f24 = convertView.findViewById(R.id.f24);
            TextView f15 = convertView.findViewById(R.id.f15);
            TextView f25 = convertView.findViewById(R.id.f25);
            TextView f16 = convertView.findViewById(R.id.f16);
            TextView f26 = convertView.findViewById(R.id.f26);


            if (values.get(position).getT11() != null) {
                f11.setBackgroundColor(Color.BLACK);
//                f21.setBackgroundColor(Color.BLACK);
            }
//            if(values.get(position).getE11()!= null && values.get(position).getS21() != null){
//                f21.setBackgroundColor(Color.BLACK);
//            }
//            if (values.get(position).getF21() != null && values.get(position).getF22() != null) {
//                Log.d("1111", "getView: "+values.get(position).getF11());
//                Log.d("2222", "getView: "+position);
//                f12.setBackgroundColor(Color.BLACK);
//                f22.setBackgroundColor(Color.BLACK);
//            }
//             if(){
//                f21.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF12() != null){
//                f12.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF22() != null){
//                f22.setBackgroundColor(Color.BLACK);
//            }
//             if (values.get(position).getF13() != null) {
//                f13.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF23() != null){
//                f23.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF14() != null){
//                f14.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF24() != null){
//                f24.setBackgroundColor(Color.BLACK);
//            }
//             if (values.get(position).getF15() != null) {
//                f15.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF25() != null){
//                f25.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF16() != null){
//                f16.setBackgroundColor(Color.BLACK);
//            }
//             if(values.get(position).getF26() != null){
//                f26.setBackgroundColor(Color.BLACK);
//            }

        } catch (Exception e){
            e.printStackTrace();
        }








        return convertView;
    }
}

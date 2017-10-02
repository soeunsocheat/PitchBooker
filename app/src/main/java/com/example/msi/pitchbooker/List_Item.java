package com.example.msi.pitchbooker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class List_Item extends ArrayAdapter<Item>{
    private Item[] time;
    private boolean book = false;
    private Context context;
    List_Item(Context context, Item[] time){
        super(context, R.layout.activity_list__item, time);
        this.context = context;
        this.time = time;
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
        Item it = time[position];
        TextView textView = convertView.findViewById(R.id.time);
        textView.setText(it.getTime());
        return convertView;
    }
}

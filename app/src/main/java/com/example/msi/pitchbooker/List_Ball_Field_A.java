package com.example.msi.pitchbooker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by MSI on 9/7/2017.
 */

public class List_Ball_Field_A extends Fragment{
    private ListView listItem;
    private ArrayAdapter<Item> items;
    public static String[] time = {"7:00 am", "8:00 am","9:00 am","10:00 am"
            , "11:00 am","12:00 pm","1:00 pm","2:00 pm","3:00 pm","4:00 pm"
            ,"5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm"};
    public static String[] time30 = {"7:30 am", "8:30 am","9:30 am","10:30 am"
            , "11:30 am","12:30 pm","1:30 pm","2:30 pm","3:30 pm","4:30 pm"
            ,"5:30 pm","6:30 pm","7:30 pm","8:30 pm","9:30 pm","10:30 pm"};

    private static Item[] times;
    {

        times = new Item[time.length * 1];
        for (int i = 0; i < time.length; i++) {
            times[i] = new Item(time[i]);
        }
//        for (int i = 0; i < namesStr.length; i++) {
//            names[namesStr.length + i] = new Student(resIds[i], namesStr[i]);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.list_ball_field, container, false);
        items = new List_Item(getActivity(), times);
        listItem = (ListView)V.findViewById(R.id.listballfield);
        listItem.setAdapter(items);
        return V;
    }
}

package com.example.msi.pitchbooker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class List_Ball_Field_D extends Fragment {
    private ListView listItem;
    private ArrayAdapter<Item> items;
    public static String[] time = {"7:00", "8:00","9:00","10:00"
            , "11:00","12:00","13:00 ","14:00","15:00","16:00"
            ,"17:00","18:00","19:00","20:00","21:00","22:00"};
    public static String[] time30 = {"7:30", "8:30","9:30","10:30"
            , "11:30","12:30","13:30 ","14:30","15:30","16:30"
            ,"17:30","18:30","19:30","20:30","21:30","22:30"};

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
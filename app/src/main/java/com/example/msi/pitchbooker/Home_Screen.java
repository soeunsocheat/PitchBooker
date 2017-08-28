package com.example.msi.pitchbooker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Screen extends Fragment implements View.OnClickListener{


    public Home_Screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home__screen, container, false);
//        TextView tv = (TextView)view.findViewById(R.id.tv);
//        tv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
//            case R.id.tv:
//                Toast.makeText(getContext(), "Home_Screen", Toast.LENGTH_SHORT).show();
//                break;
        }
    }
}

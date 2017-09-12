package com.example.msi.pitchbooker;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView tv_username = (TextView) view.findViewById(R.id.tv_username);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.data_app),getActivity().MODE_PRIVATE);
        tv_username.setText("Name : "+sharedPreferences.getString("customer_name",""));
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.getItem(R.id.changepassword).setVisible(true);
    }

}

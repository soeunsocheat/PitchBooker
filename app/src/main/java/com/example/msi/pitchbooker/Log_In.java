package com.example.msi.pitchbooker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Log_In extends Fragment implements View.OnClickListener{
    TextView tv_forgetPWD, tv_signUp;
    Button btn_login;
    Intent intent;
    public Log_In() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log__in, container, false);
        tv_forgetPWD = (TextView)view.findViewById(R.id.tv_forgetPWD);
        tv_signUp = (TextView)view.findViewById(R.id.tv_signUp);
        btn_login = (Button)view.findViewById(R.id.btn_logIn);

        tv_forgetPWD.setOnClickListener(this);
        tv_signUp.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forgetPWD:
                intent = new Intent(getContext(), Forget_Password.class);
                startActivity(intent);
                break;
            case R.id.tv_signUp:
                intent = new Intent(getContext(), Sign_Up.class);
                startActivity(intent);
                break;
            case R.id.btn_logIn:
                Home_Screen home_screen = new Home_Screen();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, home_screen);
                fragmentTransaction.commit();
        }
    }

}

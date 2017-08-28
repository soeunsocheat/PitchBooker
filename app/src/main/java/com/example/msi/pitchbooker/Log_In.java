package com.example.msi.pitchbooker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


    public Log_In() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log__in, container, false);

        TextView tv_forgetPWD = (TextView)view.findViewById(R.id.tv_forgetPWD);
        TextView tv_signUp = (TextView)view.findViewById(R.id.tv_signUp);
        Button btn_login = (Button)view.findViewById(R.id.btn_login);

        tv_forgetPWD.setOnClickListener(this);
        tv_signUp.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                Intent intent;
                intent = new Intent(Log_In.this, Home_Screen.class);
                startActivity(intent);
                break;
            case R.id.tv_forgetPWD:
                Intent intent1;
                intent1 = new Intent(Log_In.this, Forget_Password.class);
                startActivity(intent1);
                break;
            case R.id.tv_signUp:
                Intent intent2;
                intent2 = new Intent(Log_In.this, Sign_Up.class);
                startActivity(intent2);
                break;
        }
    }
}

package com.example.msi.pitchbooker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Screen extends Fragment implements View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    Button btnA, btnB, btnC, btnD;
    Intent intent;

    public Home_Screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home__screen, container, false);

        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btnA = (Button) view.findViewById(R.id.btnA);
        btnB = (Button) view.findViewById(R.id.btnB);
        btnC = (Button) view.findViewById(R.id.btnC);
        btnD = (Button) view.findViewById(R.id.btnD);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn6:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn7:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btn8:
                intent = new Intent(getContext(), List_Ball_Field.class);
                startActivity(intent);
                break;
            case R.id.btnA:
                intent = new Intent(getContext(), List_Ball_Field.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 0);
                getContext().startActivity(intent);
                break;
            case R.id.btnB:
                intent = new Intent(getContext(), List_Ball_Field.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 1);
                getContext().startActivity(intent);
                break;
            case R.id.btnC:
                intent = new Intent(getContext(), List_Ball_Field.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 2);
                getContext().startActivity(intent);
                break;
            case R.id.btnD:
                intent = new Intent(getContext(), List_Ball_Field.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hello", 3);
                getContext().startActivity(intent);
                break;
        }
    }


}

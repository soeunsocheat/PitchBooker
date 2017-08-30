package com.example.msi.pitchbooker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Forget_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget__password);
    }

    public void btn_forgetPassword(View view) {
        finish();
    }
}

package com.example.msi.pitchbooker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class First_Screen extends AppCompatActivity {
    ImageView iv;
    String restoredname, restoredpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__screen);
        iv = (ImageView)findViewById(R.id.iv_logo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        iv.startAnimation(myanim);
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.data_app), MODE_PRIVATE);
        restoredname = sharedPreferences.getString("customer_name", null);
        restoredpwd = sharedPreferences.getString("customer_password", null);
        if(restoredname != null && restoredpwd != null){
            final Intent intent = new Intent(this, MainActivity.class);
            Thread thread = new Thread(){
                public void run(){
                    try {
                        sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    finally {
                        startActivity(intent);
                        finish();
                    }
                }
            };
            thread.start();
        }else{
            final Intent intent = new Intent(this, Log_In.class);
            Thread thread = new Thread(){
                public void run(){
                    try {
                        sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    finally {
                        startActivity(intent);
                        finish();
                    }
                }
            };
            thread.start();
        }
    }
}

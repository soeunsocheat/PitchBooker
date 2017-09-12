package com.example.msi.pitchbooker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;

public class List_Sport_Club extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__sport__club);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("A").setIndicator("A"),
                List_Ball_Field_A.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("B").setIndicator("B"),
                List_Ball_Field_B.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("C").setIndicator("C"),
                List_Ball_Field_C.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("D").setIndicator("D"),
                List_Ball_Field_D.class, null);

        Intent intent = getIntent();
        mTabHost.setCurrentTab(intent.getIntExtra("hello", 0));
    }
}
package com.example.msi.pitchbooker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class List_Ball_Field extends Activity {

    TabHost mTabHost;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ball_field);

        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mTabHost.addTab(mTabHost.newTabSpec("ball field A").setIndicator("A").setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("ball field B").setIndicator("B").setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("ball field C").setIndicator("C").setContent(R.id.tab3));
        mTabHost.addTab(mTabHost.newTabSpec("ball field D").setIndicator("D").setContent(R.id.tab4));

        mTabHost.setCurrentTab(getIntent().getIntExtra("hello", 0));
    }
}
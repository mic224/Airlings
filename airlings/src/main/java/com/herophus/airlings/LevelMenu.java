package com.herophus.airlings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LevelMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to remove "information bar" above the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //to remove the action bar (title bar)
        getSupportActionBar().hide();

        setContentView(R.layout.activity_level_menu);
    }

    public void l1_onClick(View v) {

    }

    public void l2_onClick(View v) {

    }

    public void l3_onClick(View v) {

    }

    public void l4_onClick(View v) {

    }

    public void l5_onClick(View v) {

    }

    public void l6_onClick(View v) {

    }

    public void l7_onClick(View v) {

    }

    public void l8_onClick(View v) {

    }

    public void l9_onClick(View v) {

    }

    public void l10_onClick(View v) {

    }
}

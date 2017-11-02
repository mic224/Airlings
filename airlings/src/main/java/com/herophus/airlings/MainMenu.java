package com.herophus.airlings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to remove "information bar" above the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //to remove the action bar (title bar)
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main_menu);
    }

    public void playOnClick(View v) {
        Intent intent = new Intent(getApplicationContext(), LevelMenu.class);
        startActivity(intent);
        finish();
    }

    public void rateOnClick(View v) {

    }

    public void creditsOnClick(View v) {

    }

    public void buyOnClick(View v) {

    }

    public void shareOnClick(View v) {

    }

    public void likeOnClick(View v) {

    }

    public void tweetOnClick(View v) {

    }

}

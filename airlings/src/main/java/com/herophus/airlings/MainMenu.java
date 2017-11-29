package com.herophus.airlings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void onBackPressed() {

        // display a dialog to confirm the user wants to exit the game
        // when the back button is pressed on the main menu
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit")
                .setMessage("Are you sure you want to quit Airlings?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void playOnClick(View v) {
        // when the user clicks play move to the level menu
        Intent intent = new Intent(getApplicationContext(), LevelMenu.class);
        startActivity(intent);
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

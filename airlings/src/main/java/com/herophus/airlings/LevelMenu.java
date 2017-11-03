package com.herophus.airlings;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class LevelMenu extends AppCompatActivity {

    public static final String GLOBAL_PREFS = "Prefs";
    public static final String currentLevel = "currentLevel";

    public static final String l1Rank = "l1Rank";
    public static final String l2Rank = "l2Rank";
    public static final String l3Rank = "l3Rank";
    public static final String l4Rank = "l4Rank";
    public static final String l5Rank = "l5Rank";
    public static final String l6Rank = "l6Rank";
    public static final String l7Rank = "l7Rank";
    public static final String l8Rank = "l8Rank";
    public static final String l9Rank = "l9Rank";
    public static final String l10Rank = "l10Rank";

    private int curLevel = 0;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to remove "information bar" above the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //to remove the action bar (title bar)
        getSupportActionBar().hide();

        setContentView(R.layout.activity_level_menu);

        // checking what level the user is currently on
        sharedPreferences = getSharedPreferences(GLOBAL_PREFS, MODE_PRIVATE);
        sharedPreferences.getInt(currentLevel, curLevel);

        if(curLevel == 0) {
            // this is the first run set user to be on level 1
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(currentLevel, 1);

            initRankings(editor);
        }


    }

    private void initRankings(SharedPreferences.Editor editor) {
        // initialize all rankings to 0
        editor.putInt(l1Rank, 0);
        editor.putInt(l2Rank, 0);
        editor.putInt(l3Rank, 0);
        editor.putInt(l4Rank, 0);
        editor.putInt(l5Rank, 0);
        editor.putInt(l6Rank, 0);
        editor.putInt(l7Rank, 0);
        editor.putInt(l8Rank, 0);
        editor.putInt(l9Rank, 0);
        editor.putInt(l10Rank, 0);
    }

    private void initStars() {
        ImageView iv_r1 = (ImageView) findViewById(R.id.rank1);

    }

    public void l1_onClick(View v) {
        // user can always play level 1
    }

    public void l2_onClick(View v) {
        if(curLevel >= 2) {
            // only allow the user to play level 2 if its
            // been completed or in progress

        }
    }

    public void l3_onClick(View v) {
        if(curLevel >= 3) {
            // only allow the user to play level 3 if its
            // been completed or in progress

        }
    }

    public void l4_onClick(View v) {
        if(curLevel >= 4) {
            // only allow the user to play level 4 if its
            // been completed or in progress

        }
    }

    public void l5_onClick(View v) {
        if(curLevel >= 5) {
            // only allow the user to play level 5 if its
            // been completed or in progress

        }
    }

    public void l6_onClick(View v) {
        if(curLevel >= 6) {
            // only allow the user to play level 6 if its
            // been completed or in progress

        }
    }

    public void l7_onClick(View v) {
        if(curLevel >= 7) {
            // only allow the user to play level 7 if its
            // been completed or in progress

        }
    }

    public void l8_onClick(View v) {
        if(curLevel >= 8) {
            // only allow the user to play level 8 if its
            // been completed or in progress

        }
    }

    public void l9_onClick(View v) {
        if(curLevel >= 9) {
            // only allow the user to play level 9 if its
            // been completed or in progress

        }
    }

    public void l10_onClick(View v) {
        if(curLevel >= 10) {
            // only allow the user to play level 10 if its
            // been completed or in progress

        }
    }
}

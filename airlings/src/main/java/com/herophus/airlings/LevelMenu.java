package com.herophus.airlings;

import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class LevelMenu extends AppCompatActivity {

    public static final String GLOBAL_PREFS = "Prefs";
    public static final String currentLevel = "currentLevel";

    private static final int numberOfLevels = 10;
    public static final String[] rankings = new String[numberOfLevels];
    private ImageView[] ivStars = new ImageView[numberOfLevels];

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

        initRankPrefs();

        if(curLevel == 0) {
            // this is the first run set user to be on level 1
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(currentLevel, 1);

            initRankings(editor);
        }

        initLayout();

    }

    // initialize all the shared preference variables for the number
    // of levels on this page.
    private void initRankPrefs() {
        for(int i = 0; i < numberOfLevels; i++) {
            rankings[i] = "l" + i + "Rank";
        }
    }

    // initialize all rankings to 0 for first run
    private void initRankings(SharedPreferences.Editor editor) {
        for(int i = 1; i <= numberOfLevels; i++) {
            editor.putInt("l" + i + "Rank", 0);
        }
        editor.commit();
    }

    private void initLayout() {
        ConstraintLayout cl = findViewById(R.id.level_menu_layout);
        ConstraintSet cs = new ConstraintSet();

        // loop the first half of the levels
        for(int i = 0; i < numberOfLevels/2; i++) {
            ivStars[i] = new ImageView(this);
            // set the id for connections
            ivStars[i].setId(i);

            // dont forget to add the ImageView to the layout
            cl.addView(ivStars[i]);
            // sets the constraint parameters with 50dp x 25dp to match the images
            ConstraintLayout.LayoutParams cp = new ConstraintLayout.LayoutParams(dp(50),
                    dp(25));

            // constrain the ImageViews dimensions
            cs.constrainWidth(ivStars[i].getId(), dp(50));
            cs.constrainHeight(ivStars[i].getId(), dp(25));
            if( i > 0) {

                // constrain the image view to the center of the screen
//                cs.center(ivStars[i].getId(), ConstraintSet.PARENT_ID, ConstraintSet.LEFT,
//                        0, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,
//                        0, 0.5f);

                // connect this ImageView with the next one in the list
                cs.connect(ivStars[i-1].getId(), ConstraintSet.LEFT, ivStars[i].getId(),
                        ConstraintSet.RIGHT, 16);

            } else {
                cs.connect(ivStars[i].getId(), ConstraintSet.TOP, cl.getId(),
                        ConstraintSet.TOP, 0);
            }
            // apply the constraints to the layout
            cs.applyTo(cl);
            // setting an image just for testing right now
            ivStars[i].setImageResource(R.drawable.empty_star);
        }
    }

    // returns the dp value for different density screens
    private int dp(int dpValue) {
        float d = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue * d);
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

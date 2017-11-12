package com.herophus.airlings;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LevelMenu extends AppCompatActivity {

    private static final ImageView[] ivStars = new ImageView[GamePreferences.getNumberOfLevels()];
    private static final Button[] butLevels = new Button[GamePreferences.getNumberOfLevels()];

    private int curLevel = 0;

    // for generating unique ids
    private static int id = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to remove "information bar" above the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //to remove the action bar (title bar)
        getSupportActionBar().hide();

        setContentView(R.layout.activity_level_menu);

        // Initialize shared preferences singleton if its not already
        // initialized
        GamePreferences.init(this);

        // checking what level the user is currently on
        curLevel = GamePreferences.getCurrentLevel();


        if (curLevel == 0) {
            // this is the first run set user to be on level 0
            GamePreferences.setCurrentLevel(1);

            initRankings();
        }

        initLayout();

    }

    // initialize all rankings to 0 for first run
    private void initRankings() {
        for (int i = 0; i < GamePreferences.getNumberOfLevels(); i++) {
            GamePreferences.setLevelRank(GamePreferences.LEVEL[i], 0);
        }
    }

    // helper function to initialize the star
    // images based on the rank achieved
    private void initStars(int i) {
        int value = GamePreferences.getLevelRank(GamePreferences.LEVEL[i]);
        switch (value) {
            case 0:
                ivStars[i].setImageResource(R.drawable.empty_star);
                break;
            case 1:
                ivStars[i].setImageResource(R.drawable.bronze_star);
                break;
            case 2:
                ivStars[i].setImageResource(R.drawable.silver_star);
                break;
            case 3:
                ivStars[i].setImageResource(R.drawable.gold_star);
                break;
        }
    }

    // helper function to initialize the layout of the menu
    // makes 4 rows of Views (stars directly under buttons):
    // row 1: Buttons: The levels
    // row 2: ImageViews: a star based on the rank achieved on the level
    // row 3: Buttons: upper levels
    // row 4: ImageViews: a star based on the rank achieved on the level
    private void initLayout() {
        ConstraintLayout cl = findViewById(R.id.level_menu_layout);
        ConstraintSet cs = new ConstraintSet();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lpStar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        // this changes the amount of space between stars and buttons
        lpStar.setMargins(dp(0), dp(0), dp(0), dp(32));

        // create a LinearLayout for each row of stars and buttons
        LinearLayout[] llButtons = new LinearLayout[2];
        LinearLayout[] llStars = new LinearLayout[2];

        // another LinearLayout vertically to align all the rows
        LinearLayout vert = new LinearLayout(this);
        vert.setId(findId());
        vert.setLayoutParams(lp);
        vert.setOrientation(LinearLayout.VERTICAL);
        vert.setVerticalGravity(Gravity.NO_GRAVITY);

        for (int i = 0; i < 2; i++) {
            // create the layouts for each of the button rows
            llButtons[i] = new LinearLayout(this);
            llButtons[i].setId(findId());
            llButtons[i].setMinimumWidth(dp(576));
            llButtons[i].setLayoutParams(lp);
            llButtons[i].setOrientation(LinearLayout.HORIZONTAL);
            llButtons[i].setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

            // create the layouts for each of the star rows
            llStars[i] = new LinearLayout(this);
            llStars[i].setId(findId());
            llStars[i].setMinimumWidth(dp(576));
            llStars[i].setLayoutParams(lpStar);
            llStars[i].setOrientation(LinearLayout.HORIZONTAL);
            llStars[i].setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        }

        for (int i = 0; i < GamePreferences.getNumberOfLevels(); i++) {
            butLevels[i] = new Button(this);
            butLevels[i].setId(findId());

            // place each button in the correct row
            if (i < GamePreferences.getNumberOfLevels() / 2) {
                // lower level row
                llButtons[0].addView(butLevels[i]);
            } else {
                // upper levels
                llButtons[1].addView(butLevels[i]);
            }


            // sets the dimensions of the button objects
            butLevels[i].getLayoutParams().width = dp(50);
            butLevels[i].getLayoutParams().height = dp(50);

            // now for the stars
            ivStars[i] = new ImageView(this);
            ivStars[i].setId(findId());

            // place the stars in the correct row
            if (i < GamePreferences.getNumberOfLevels() / 2) {
                // lower levels
                llStars[0].addView(ivStars[i]);
            } else {
                // upper levels
                llStars[1].addView(ivStars[i]);
            }

            // star dimensions
            ivStars[i].getLayoutParams().width = dp(50);
            ivStars[i].getLayoutParams().height = dp(25);

            // initialize all star images based on rank achieved on that
            // level
            initStars(i);
        }

        // connect the new layouts up to the rest of the layout
        cs.connect(vert.getId(), ConstraintSet.TOP, R.id.iv_progress, ConstraintSet.BOTTOM,
                dp(32));
        cs.connect(vert.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM, 8);
        cs.connect(vert.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID,
                ConstraintSet.START, 8);
        cs.connect(vert.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID,
                ConstraintSet.END, 8);

        // add the horizontal LinearLayout to the vertical LinearLayout
        for (int i = 0; i < 2; i++) {
            vert.addView(llButtons[i]);
            vert.addView(llStars[i]);
        }

        // add the everything to the overall layout
        cl.addView(vert);

        // display
        cs.applyTo(cl);
    }

    // returns the dp value for different density screens
    private int dp(int dpValue) {
        float d = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * d);
    }

    // returns a valid id that is unique and not already in use
    public int findId() {
        View v = findViewById(id);
        while (v != null) {
            v = findViewById(++id);
        }
        return id++;
    }

}

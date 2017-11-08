package com.herophus.airlings;

import android.content.SharedPreferences;
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

    public static final String GLOBAL_PREFS = "Prefs";
    public static final String currentLevel = "currentLevel";

    private static final int numberOfLevels = 20;
    public static final String[] rankings = new String[numberOfLevels];
    private ImageView[] ivStars = new ImageView[numberOfLevels];
    private Button[] butLevels = new Button[numberOfLevels];

    private int curLevel = 0;

    private SharedPreferences sharedPreferences;

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

        // checking what level the user is currently on
        sharedPreferences = getSharedPreferences(GLOBAL_PREFS, MODE_PRIVATE);
        sharedPreferences.getInt(currentLevel, curLevel);

        initRankPrefs();

        if (curLevel == 0) {
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
        for (int i = 0; i < numberOfLevels; i++) {
            rankings[i] = "l" + i + "Rank";
        }
    }

    // initialize all rankings to 0 for first run
    private void initRankings(SharedPreferences.Editor editor) {
        for (int i = 1; i <= numberOfLevels; i++) {
            editor.putInt("l" + i + "Rank", 0);
        }
        editor.commit();
    }

    private void initLayout() {
        ConstraintLayout cl = findViewById(R.id.level_menu_layout);
        ConstraintSet cs = new ConstraintSet();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lpStar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);


        lpStar.setMargins(dp(0), dp(0), dp(0), dp(32));

        LinearLayout[] llButtons = new LinearLayout[2];
        LinearLayout[] llStars = new LinearLayout[2];

        LinearLayout vert = new LinearLayout(this);
        vert.setId(findId());
        vert.setLayoutParams(lp);
        vert.setOrientation(LinearLayout.VERTICAL);
        vert.setVerticalGravity(Gravity.NO_GRAVITY);

        for(int i = 0; i < 2; i++) {
            llButtons[i] = new LinearLayout(this);
            llButtons[i].setId(findId());
            llButtons[i].setMinimumWidth(dp(576));
            llButtons[i].setLayoutParams(lp);
            llButtons[i].setOrientation(LinearLayout.HORIZONTAL);
            llButtons[i].setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

            llStars[i] = new LinearLayout(this);
            llStars[i].setId(findId());
            llStars[i].setMinimumWidth(dp(576));
            llStars[i].setLayoutParams(lpStar);
            llStars[i].setOrientation(LinearLayout.HORIZONTAL);
            llStars[i].setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        }

        for (int i = 0; i < numberOfLevels; i++) {
            butLevels[i] = new Button(this);
            butLevels[i].setId(findId());

            if(i < numberOfLevels/2) {
                llButtons[0].addView(butLevels[i]);
            } else {
                llButtons[1].addView(butLevels[i]);
            }


            butLevels[i].getLayoutParams().width = dp(50);
            butLevels[i].getLayoutParams().height = dp(50);

            ivStars[i] = new ImageView(this);
            // set the id for connections
            ivStars[i].setId(findId());
            ivStars[i].setImageResource(R.drawable.empty_star);

            if(i < numberOfLevels/2) {
                llStars[0].addView(ivStars[i]);
            } else {
                llStars[1].addView(ivStars[i]);
            }

            ivStars[i].getLayoutParams().width = dp(50);
            ivStars[i].getLayoutParams().height = dp(25);
        }


        cs.connect(vert.getId(), ConstraintSet.TOP, R.id.iv_progress, ConstraintSet.BOTTOM,
                dp(32));
        cs.connect(vert.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM, 8);
        cs.connect(vert.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID,
                ConstraintSet.START, 8);
        cs.connect(vert.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID,
                ConstraintSet.END, 8);

        vert.addView(llButtons[0]);
        vert.addView(llStars[0]);
        vert.addView(llButtons[1]);
        vert.addView(llStars[1]);

        cl.addView(vert);

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
        while(v != null) {
            v = findViewById(++id);
        }
        return id++;
    }

}

package com.herophus.airlings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by michael on 12/11/17.
 */

public class GamePreferences {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final int NUMBER_OF_LEVELS = 14;

    public static String[] LEVEL = new String[NUMBER_OF_LEVELS];

    public enum Setting {
        CURRENT_LEVEL
    }

    private GamePreferences () {}

    public static void init(Context context) {
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(),
                    Activity.MODE_PRIVATE);

            editor = sharedPreferences.edit();

            for(int i = 0; i < NUMBER_OF_LEVELS; i++) {
                LEVEL[i] = "LEVEL_" + i;
            }
        }
    }

    public static int getNumberOfLevels() {
        return NUMBER_OF_LEVELS;
    }

    public static int getCurrentLevel() {
        return sharedPreferences.getInt(Setting.CURRENT_LEVEL.name(), 0);
    }

    public static void setCurrentLevel(int value) {
        editor.putInt(Setting.CURRENT_LEVEL.name(), value);
        editor.commit();
    }

    public static int getLevelRank(String levelKey) {
        return sharedPreferences.getInt(levelKey, 0);
    }

    public static void setLevelRank(String levelKey, int rank) {
        editor.putInt(levelKey, rank);
        editor.commit();
    }

}

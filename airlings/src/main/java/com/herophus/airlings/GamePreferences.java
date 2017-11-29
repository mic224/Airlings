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

    // This is the number of levels in the game
    // allows for dynamically changing the amount
    // of levels for adding more levels in the future.
    private static final int NUMBER_OF_LEVELS = 14;

    // This is the array of levels in the game. The array
    // of strings will be used as a key.
    public static String[] LEVEL = new String[NUMBER_OF_LEVELS];

    public enum Setting {
        HIGHEST_LEVEL_ACHEIVED, // the highest level playable
        CURRENT_LEVEL, // the level the player has chosen to play
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

    public static int getHighestLevel() {
        return sharedPreferences.getInt(Setting.HIGHEST_LEVEL_ACHEIVED.name(), 0);
    }

    public static void setHighestLevel(int value) {
        editor.putInt(Setting.HIGHEST_LEVEL_ACHEIVED.name(), value);
        editor.commit();
    }

    public static int getCurrentLevel() {
        return sharedPreferences.getInt(Setting.CURRENT_LEVEL.name(), 0);
    }

    public static void setCurrentLevel(int value) {
        editor.putInt(Setting.CURRENT_LEVEL.name(), value);
    }

    public static int getLevelRank(String levelKey) {
        return sharedPreferences.getInt(levelKey, 0);
    }

    public static void setLevelRank(String levelKey, int rank) {
        editor.putInt(levelKey, rank);
        editor.commit();
    }

    public static Boolean getFirstRun() {
        return sharedPreferences.getBoolean("firstRun", true);
    }

    public static void setFirstRunFalse() {
        editor.putBoolean("firstRun", false);
        editor.commit();
    }
}

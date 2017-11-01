package com.herophus.airlings;

/**
 * Created by michael on 27/10/17.
 */

class GameState {

    GLRenderer renderer;

    State currentState;

    public enum State {
        SPLASH,
        MENU,
        LEVELS,
        OPTIONS,
        PLAYING,
        PAUSED
    }

    GameState(GLRenderer rend) {
        currentState = State.SPLASH;
    }

}
